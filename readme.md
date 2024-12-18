
# Use cases for cross-project model sharing infrastructure

TBD

## Setup

At the moment of writing, running the use cases requires a custom-built Gradle distribution from:
- https://github.com/gradle/gradle/pull/31813

For most convenience, build an "all distribution" of Gradle,
following [these instructions](https://github.com/gradle/gradle/blob/master/CONTRIBUTING.md#building-a-distribution-from-source):

```
./gradlew :distributions-full:allDistributionZip
```

Then set the wrapper for the use case builds:

```
# In use-cases/<use-case-directory>/gradle/wrapper/gradle-wrapper.properties
distributionUrl=file://<path to Gradle repo>/subprojects/distributions-full/build/distributions/gradle-8.13-all.zip
```
