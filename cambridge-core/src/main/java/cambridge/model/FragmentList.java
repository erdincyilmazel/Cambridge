package cambridge.model;

import cambridge.behaviors.ConditionalTagBehavior;
import cambridge.TemplateParsingException;

import java.util.ArrayList;
import java.util.Iterator;

import static cambridge.behaviors.ConditionalTagBehavior.ConditionType.FIRST;

/**
 * User: erdinc
 * Date: Oct 13, 2009
 * Time: 1:01:56 PM
 */
public class FragmentList extends ArrayList<Fragment> {
   public FragmentList() {
   }

   Fragment current;

   public FragmentList append(String contents) {
      if (!(current instanceof StaticFragment)) {
         if (current != null) {
            add(current);
         }
         current = new StaticFragment();
      }

      ((StaticFragment) current).append(contents);
      return this;
   }

   public void addFragment(Fragment f) {
      if (current != null) {
         add(current);
      }

      current = f;
   }

   private TagNode getNextTag(TagNode t) {
      TemplateNode next = t.getNextSibling();
      TemplateNode nextNext = null;

      if (next instanceof TextNode && ((TextNode) next).isWhiteSpace()) {
         nextNext = next.getNextSibling();
      }

      return (next instanceof TagNode) ? (TagNode) next :
         (nextNext instanceof TagNode) ? (TagNode) nextNext : null;
   }

   public void pack() {
      if (current != null) {
         add(current);
      }

      mergeConditionalBlocks();

      for (Fragment f : this) {
         f.pack();
      }
   }

   private void mergeConditionalBlocks() {
      if (size() < 2) {
         return;
      }

      ArrayList<TagNode> conditionals = new ArrayList<TagNode>();
      for (Fragment f : this) {
         if (f instanceof TagNode) {
            TagNode t = (TagNode) f;
            ConditionalTagBehavior behavior = t.getConditionalBehavior();
            if (behavior != null) {
               conditionals.add(t);
            }
         }
      }

      if (conditionals.size() == 0) {
         return;
      }

      ArrayList<ConditionalBlock> blocks = new ArrayList<ConditionalBlock>();

      for (int i = 0; i < conditionals.size(); i++) {
         ConditionalBlock currentBlock = null;
         TagNode t = conditionals.get(i);

         ConditionalTagBehavior behavior = t.getConditionalBehavior();

         main:
         do {
            TagNode nextTag = getNextTag(t);

            TagNode nextConditional = i + 1 < conditionals.size() ? conditionals.get(i + 1) : null;

            if (currentBlock == null && behavior.getType() == FIRST
               && nextTag == nextConditional && nextTag != null
               && nextConditional.getConditionalBehavior().getType() != FIRST) {
               currentBlock = new ConditionalBlock(t);
            }

            if (nextTag == null || nextConditional == null) {
               break;
            }

            if (currentBlock == null && behavior.getType() != FIRST) {
               throw new TemplateParsingException(behavior.getValidationError(), nextTag.getBeginLine(), nextTag.getBeginColumn());
            }

            if (nextTag == nextConditional) {
               switch (nextTag.getConditionalBehavior().getType()) {
                  case FIRST:
                     break main;
                  case ALTERNATE:
                     currentBlock.addAlternateCondition(nextTag);
                     break;
                  case DEFAULT:
                     currentBlock.setDefaultCondition(nextTag);
                     i++;
                     t = nextTag;
                     break main;
               }
            } else {
               break;
            }

            i++;
            t = nextTag;
         } while (true);

         if (currentBlock != null) {
            if (currentBlock.isComplete()) {
               blocks.add(currentBlock);
            }
         }
      }

      for (ConditionalBlock block : blocks) {
         TagNode first = block.getFirstTag();
         TagNode last = block.getLastTag();

         int i = 0;
         Iterator<Fragment> iter = iterator();
         boolean remove = false;
         while (iter.hasNext()) {
            Fragment cur = iter.next();
            if (remove) {
               iter.remove();
            }

            if (cur == last) {
               break;
            }

            if (cur == first) {
               set(i, block);
               remove = true;
            }
            i++;
         }
      }
   }
}
