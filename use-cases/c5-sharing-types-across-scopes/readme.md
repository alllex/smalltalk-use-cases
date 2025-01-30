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

### Some plugins for settings scripts (`Plugin<Settings>`)

Allows code in settings scripts to contribute and inspect data. Will also automatically apply
the project plugin to every project, unless the project chooses to skip auto-application (via `gradle.properties`).

### Some plugins for project build scripts (`Plugin<Project>`)

Allows code in project build logic to contribute and inspect data.

## Build structure

This basic build contains a few projects which we apply `ProjectPlugin` and  `ProjectPlugin2` to.
We also apply `SettingsPlugin` in `settings.gradle.kts`, and additional included builds that do the same.

We try to apply `GradlePlugin` in the custom `custom.init.gradle.kts` script (specified via `gradle help -I custom.init.gradle.kts`),
but that does not work due to different classloaders being used.

## Testing

This needs a build from the branch that backs [this PR](https://github.com/gradle/gradle/pull/32235).

`gradle help`

shows we get different type instances for `LanguageMetadata` across builds in a composite build, but only if we are careful
and apply the same plugins everywhere (projects for cross-project compatibility, and settings for cross-build compatibility).

However,

`gradle help -I custom.init.gradle.kts`

will not work.

