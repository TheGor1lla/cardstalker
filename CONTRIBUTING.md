# Contributing to cardstalker

cardstalker was built as a fun project to keep my card collection up-to-date. While it has a working alternative, I want to rebuilt it with this tech stack and make it maintainable.

## Ideal for contribution

The app can always be expanded to include more than just magic cards, but everything cardmarket has to offer. For non-coders enhancements to the README or adding languages is always welcome.

## Using GitHub Issues

We use GitHub issues to track bugs and enhancements.

If you are reporting a bug, please help to speed up problem diagnosis by providing as much
information as possible.

Please look for other issues or pull requests which already work on this topic. Is somebody already on it? Do you need to synchronize?

## Reporting Security Vulnerabilities

If you think you have found a security vulnerability in the cardstalker app, feel free to create a pull request and I'll do my best to mark it as a hacktober issue.


## Code Conventions and Housekeeping
None of these is essential for a pull request, but they will all help.
They can also be added after the original pull request but before a merge.

* Add meaningful commit messages.
* A few unit tests, where useful, are awesome!
* If no-one else is using your branch, please rebase it against the current main

## Working with the Code
If you don't have an IDE preference I would recommend that you use
[the Intellij Community Edition](https://www.jetbrains.com/idea/download).


### Building from Source
The cardstalker source can be build from the command line using
[Apache Maven](http://maven.apache.org/run-maven/index.html) on JDK 11 or above.
I included '`Maven Wrapper`' scripts (`./mvnw` or `mvnw.bat`) that you can run rather
than needing to install Maven locally.


#### Default Build
The project can be built from the root directory using the standard Maven command:

	$ ./mvnw clean verify

The app should always be runnable with the local setup without any special configuration. Any other environment like stage or prod should include needed configuration as docs.
