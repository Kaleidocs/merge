# Kaleidocs/merge

A Clojure wrapper for [XDocReport][1].
Works on [Open Document Format for Office Applications][2] and [Velocity][3] syntax.

[1]: http://code.google.com/p/xdocreport/
[2]: http://www.documentfoundation.org/
[3]: http://velocity.apache.org/

## Installation

Include Kaleidocs/merge in your `project.clj`:

![Kaleidocs/merge at Clojars](https://clojars.org/kaleidocs/merge/latest-version.svg)

then also in your `project.clj`, add templates engine(s) to dev dependencies:

```clojure
:profiles
{:dev
   {:dependencies
    [[fr.opensagres.xdocreport/fr.opensagres.xdocreport.document.odt "1.0.3"]
     [fr.opensagres.xdocreport/fr.opensagres.xdocreport.document.ods "1.0.3"]]}}
```
(You should not add these templates engines to your dependencies.
See Packaging section for details.)

In your namespace:

```clojure
(require '[kaleidocs.merge :refer [merge-doc]])
```

## Usage
### Simple structure

Create ODT/ODS templates with LibreOffice / OpenOffice.
Templates are just normal office files with some placeholders typed
directly inside.
Follow velocity syntax, something like this:

- In the file `simple-template.odt`:

```
Hello $name!
```

Now execute from clojure:

```clojure
(merge-doc "simple-template.odt"
           "simple-output.odt"
           {"name" "World"})
```

- the file `simple-output.odt` should now contain:

```
Hello World!
```

ODS templates work the same way.

### Documents with repeated rows in tables (ODT only)

- Create a table (you can type placeholders directly without the XDocReport extension for LibreOffice / Open Office)

![Making template](http://wiki.xdocreport.googlecode.com/git/screenshots/ODTQuickStart_MacroInsertListFieldInPargraph3.png)

- Let XDocReport do the heavy lifting

```clojure
(merge-doc "simple-template.odt"
           "simple-output.odt"
           ;; columns
           ["developers.Name", "developers.Mail", "developers.LastName"]
           ;; data
           {"project" {"Name" "XDocReport"},
            "developers"
            [{"Name" "ZERR",
              "Mail" "angelo.zerr@gmail.com",
              "LastName" "Angelo"},
             {"Name" "Leclercq",
              "Mail" "pascal.leclercq@gmail.com",
              "LastName" "Pascal"}]})
```
![Result](http://wiki.xdocreport.googlecode.com/git/screenshots/ODTReportingQuickStart_MacroOverview2.png)

More [information][1] about creating templates
(about XDocReport extension for LibreOffice / OpenOffice, too)

[1]: http://code.google.com/p/xdocreport/wiki/ODTReportingQuickStart

## License

Copyright © 2014 Hoang Minh Thang

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
