# Contributing

Here are instructions to get you
started. They are probably not perfect, please let us know if anything
feels wrong or incomplete.

## Reporting Issues

Issues can be reported in [the GitHub issue tracker](https://github.com/bjhargrave/add-maven-descriptor/issues).
Please include the steps required to reproduce the problem if possible and applicable.
This information will help us review and fix your issue faster.

## Build Environment

The only thing you need to build Java. We require at least Java 8.
We use Maven to build and the repo includes `gradlew`.
You can use your system `gradle` but we require a recent version.

- `./gradlew clean build` - Assembles and tests the project

We use [GitHub Actions](https://github.com/bjhargrave/add-maven-descriptor/actions/workflows/cibuild.yml) and the repo includes a
`.github/workflows/cibuild.yml` file to build with GitHub Actions.

## Workflow

We use [git triangular workflow](https://github.blog/2015-07-29-git-2-5-including-multiple-worktrees-and-triangular-workflows/).
This means that no one, not even the maintainers, push contributions directly into the [main repo](https://github.com/bjhargrave/add-maven-descriptor). All contribution come in through pull requests.
So each contributor will need to [fork the main repo](https://github.com/bjhargrave/add-maven-descriptor/fork)
on GitHub. All contributions are made as commits to your fork. Then you submit a
pull request to have them considered for merging into the main repo.

### Setting up the triangular workflow

After forking the main repo on GitHub, you can clone the main repo to your system:

    git clone https://github.com/bjhargrave/add-maven-descriptor.git

This will clone the main repo to a local repo on your disk and set up the `origin` remote in Git.
Next you will set up the second side of the triangle to your fork repo.

    cd add-maven-descriptor
    git remote add fork git@github.com:github-user/add-maven-descriptor.git

Make sure to replace the URL with the SSH URL to your fork repo on GitHub. Then we configure
the local repo to push your commits to the fork repo.

    git config remote.pushdefault fork

So now you will pull from `origin`, the main repo, and push to `fork`, your fork repo.
This option requires at least Git 1.8.4. It is also recommended that you configure

    git config push.default simple

unless you are already using Git 2.0 where it is the default.

Finally, the third side of the triangle is pull requests from your fork repo to the
main repo.

## Contribution guidelines

### Pull requests are always welcome

We are always thrilled to receive pull requests, and do our best to
process them as fast as possible. Not sure if that typo is worth a pull
request? Do it! We will appreciate it.

If your pull request is not accepted on the first try, don't be
discouraged! If there's a problem with the implementation, hopefully you
received feedback on what to improve.

### Create issues

Any significant improvement should be documented as [a GitHub
issue](https://github.com/bjhargrave/add-maven-descriptor/issues) before anybody
starts working on it.

### ... but check for existing issues first

Please take a moment to check that an issue doesn't already exist
documenting your bug report or improvement proposal. If it does, it
never hurts to add a quick "+1" or "I have this problem too". This will
help prioritize the most common problems and requests.

### Conventions

Fork the repo and make changes on your fork in a feature branch:

- If it's a bugfix branch, name it XXX-something where XXX is the number of the
  issue
- If it's a feature branch, create an enhancement issue to announce your
  intentions, and name it XXX-something where XXX is the number of the issue.

Submit unit tests for your changes. We use JUnit 5. Run the full build including all
the tests in your branch before submitting a pull request. Having GitHub Actions set up for your fork repo is quite a help here.

Write clean code. Universally formatted code promotes ease of writing, reading,
and maintenance. We use Eclipse and the project has Eclipse `.settings` which
will properly format the code. Make sure to avoid unnecessary white space changes
which complicate diffs and make reviewing pull requests much more time consuming.

Pull requests descriptions should be as clear as possible and include a
reference to all the issues that they address.

Pull requests must not contain commits from other users or branches.

Commit messages must start with a short summary (max. 50
chars) written in the imperative, followed by an optional, more detailed
explanatory text which is separated from the summary by an empty line.

    index: Remove absolute URLs from the OBR index

    The url for the root was missing a trailing slash. Using File.toURI to
    create an acceptable url.

Code review comments may be added to your pull request. Discuss, then make the
suggested modifications and push additional commits to your feature branch. Be
sure to post a comment after pushing. The new commits will show up in the pull
request automatically, but the reviewers will not be notified unless you
comment.

Before the pull request is merged, make sure that you squash your commits into
logical units of work using `git rebase -i` and `git push -f`. After every
commit, the test suite should be passing. Include documentation changes in the
same commit so that a revert would remove all traces of the feature or fix.

Commits that fix or close an issue should include a reference like `Closes #XXX`
or `Fixes #XXX`, which will automatically close the issue when merged.

### Sign your work

Sign off on your commit in the footer. By doing this, you assert original
authorship of the commit and that you are permitted to contribute it. This can
be automatically added to your commit by passing `-s` to `git commit`, or by
hand adding the following line to the footer of the commit.

    Signed-off-by: Full Name <email>

Remember, if a blank line is found anywhere after the `Signed-off-by` line, the
`Signed-off-by:` will be considered outside of the footer, and will fail the
automated Signed-off-by validation.

It is important that you read and understand the legal considerations found
below when signing off or contributing any commit.

### Large changes/Work-In-Progress

Sometimes for big changes/feature additions, you may wish to submit a pull
request before it is fully ready to merge, in order to solicit feedback from the
core developers and ensure you're on the right track before proceeding too far.
In this case, you can submit a pull request and mark it as a
draft in GitHub.

Once your pull request is ready for consideration to merge, remove the draft status from the pull request to signal this fact to the core team. While the pull request is
marked as draft the maintainers are unlikely to know that it is ready, the
review process won't start and your branch won't get merged.

### Merge approval

The maintainers will review your pull request and, if approved, will merge into
the main repo.

If your pull request was originally a work-in-progress, don't forget to remove WIP from its title
to signal to the maintainers that it is ready for review.
