package cambridge.model;

import java.util.ArrayList;

/**
 * @author Erdinc Yilmazel
 * Date: Nov 7, 2009
 * Time: 7:52:11 PM
 */
public interface ModifyableTag {
   ArrayList<TagPart> getTagParts();

   void setTagParts(ArrayList<TagPart> tagParts);

   FragmentList getFragments();

   void setFragments(FragmentList fragments);
}
