#!/bin/bash

mvn clean source:jar javadoc:jar package

target=$1
rm -rf $target
mkdir $target
mkdir $target/javadoc
mkdir $target/sources
mkdir $target/lib

mv cambridge-jaxrs/target/cambridge-jaxrs*-sources.jar $target/sources/
mv cambridge-jaxrs/target/cambridge-jaxrs*-javadoc.jar $target/javadoc/
mv cambridge-jaxrs/target/cambridge-jaxrs*.jar $target/

mv cambridge-mvel/target/cambridge-mvel*-sources.jar $target/sources/
mv cambridge-mvel/target/cambridge-mvel*-javadoc.jar $target/javadoc/
mv cambridge-mvel/target/cambridge-mvel*.jar $target/

mv cambridge-ognl/target/cambridge-ognl*-sources.jar $target/sources/
mv cambridge-ognl/target/cambridge-ognl*-javadoc.jar $target/javadoc/
mv cambridge-ognl/target/cambridge-ognl*.jar $target/

mv cambridge-janino/target/cambridge-janino*-sources.jar $target/sources/
mv cambridge-janino/target/cambridge-janino*-javadoc.jar $target/javadoc/
mv cambridge-janino/target/cambridge-janino*.jar $target/

mv cambridge-jexl/target/cambridge-jexl*-sources.jar $target/sources/
mv cambridge-jexl/target/cambridge-jexl*-javadoc.jar $target/javadoc/
mv cambridge-jexl/target/cambridge-jexl*.jar $target/

mv cambridge-playframework/target/cambridge-playframework*-sources.jar $target/sources/
mv cambridge-playframework/target/cambridge-playframework*-javadoc.jar $target/javadoc/
mv cambridge-playframework/target/cambridge-playframework*.jar $target/

mv cambridge-core/target/cambridge-core*-sources.jar $target/sources/
mv cambridge-core/target/cambridge-core*-javadoc.jar $target/javadoc/
mv cambridge-core/target/cambridge-core*.jar $target/

cp lib/* $target/lib
tar cjf $target.tar.bz2 $target
tar czf $target.tar.gz $target
