(defproject kaleidocs/merge "0.2.0"
  :description "A Clojure wrapper for XDocReport"
  :url "https://github.com/Kaleidocs/merge"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main kaleidocs.merge
  :aot :all
  :dependencies
  [[org.clojure/clojure "1.5.1"]
   [fr.opensagres.xdocreport/fr.opensagres.xdocreport.document "1.0.3"]
   [fr.opensagres.xdocreport/fr.opensagres.xdocreport.document.odt "1.0.3"]
   [fr.opensagres.xdocreport/fr.opensagres.xdocreport.document.ods "1.0.3"]
   [fr.opensagres.xdocreport/fr.opensagres.xdocreport.template "1.0.3"]
   [fr.opensagres.xdocreport/fr.opensagres.xdocreport.template.velocity "1.0.3"]])
