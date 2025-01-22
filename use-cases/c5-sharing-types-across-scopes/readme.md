This project is an exploration on how can users use the same type (interface / class) in different scopes, e.g. in project plugins, build scripts, settings scripts and init scripts.

Put simply, where can a user declare the type, such that it is accessible in the scopes they want?

Also we must consider if the same user-defined type (from the same classloader) can be shared between builds in a composite build.

It might be helpful to consult the structure of classloaders in Gradle:

See discovery spec here: https://docs.google.com/document/d/1uFYVbc7u81IXPMXhRYLnQNCRxjWthrsAEipafdWEgHw/edit?tab=t.0

# Details on the Demo

## Plugins

Plugins are defined in an included build named `scoped-data-plugin`. This build also
defines its data types in another (nested) included build (named `api-build`).

### A plugin for init scripts (`Plugin<Gradle>`)

Allows code in init scripts to contribute and inspect data. This does not work though,
as the Gradle plugin classloader isn't shared with the other scopes.

### A plugin for settings scripts (`Plugin<Settings>`)

Allows code in settings scripts to contribute and inspect data. Will also automatically apply
the project plugin to every project, unless the project chooses to skip auto-application (via `gradle.properties`).

### A plugin for project build scripts (`Plugin<Project>`)

Allows code in project build logic to contribute and inspect data.

## Build structure

This basic build contains a few projects which we apply `ProjectPlugin` to.
We also apply `SettingsPlugin` in `settings.gradle.kts`
And we try to apply `GradlePlugin` in the custom `custom.init.gradle.kts` script (specified via `gradle help -I custom.init.gradle.kts`),
but that does not work due to incompatible classloaders.

### Included build

There is also an included build `included-build1` meant to show the same plugin classloader seems to be used across different builds
in the build tree.

## Testing

This needs a build from the `(alllex/ip/smalltalk/type-nominal-project-models` branch.

`gradle help`

should work.

However,

`gradle help -I custom.init.gradle.kts`

will not work.

