
# Aggregating across projects

Some projects in the build are libraries, and each library can provide samples of how to use it.

We want to be able to produce a document that contains all the rendered samples.

Structure:

- `app` - demo app using a libraries, itself not a library
- `lib0` -- library that does not have samples
- `lib1` -- library that has static samples
- `lib2` -- library that has samples generated by a task