# Java Design Principles and Patterns

A collection of Java exercises that makes object-oriented design trade-offs
visible through small, runnable examples.

## What it covers

- Ten SOLID refactoring exercises covering responsibility boundaries,
  extensibility, substitution, interface segregation, and dependency inversion
- Adapter implementations for payment providers
- Proxy-based access control for reports
- Flyweight reuse for map marker styles
- Singleton behavior under concurrency, reflection, and serialization
- Immutable incident-ticket modeling

## Repository layout

```text
SOLID/                 SOLID refactoring exercises with per-exercise READMEs
adapter-payments/      Adapter pattern
proxy-reports/         Proxy pattern
flyweight-markers/     Flyweight pattern
singleton-metrics/     Singleton behavior and edge cases
immutable-tickets/     Immutability and validation
scripts/check.sh       Compile every example in isolation
```

## Validate the examples

Different exercises intentionally reuse class names, so the validation script
compiles each source tree into its own temporary output directory:

```bash
scripts/check.sh
```

To run one exercise manually:

```bash
cd SOLID/ex01/src
javac *.java
java Demo01
```

## Course context

These examples originated as low-level-design and SOLID coursework. The
repository presents the engineering ideas clearly while retaining the original
exercise-level documentation and history.

## Limitations

- The modules are independent examples rather than one deployable application.
- Validation compiles the sources but does not yet assert behavior for every
  exercise.
- No license is asserted while coursework ownership remains under review.
