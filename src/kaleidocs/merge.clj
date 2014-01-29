(ns kaleidocs.merge)

(import fr.opensagres.xdocreport.document.IXDocReport)
(import fr.opensagres.xdocreport.template.TemplateEngineKind)
(import fr.opensagres.xdocreport.document.registry.XDocReportRegistry)

(defn list-of-maps->java [coll]
  (java.util.ArrayList.
   (map #(java.util.HashMap. %) coll)))

(defn merge-doc
  "Produce (aka merge) a document from an ODF template with Velocity placeholders."
  ([input-file output-file columns context-map]
     (let [in (clojure.java.io/input-stream input-file)
           out (clojure.java.io/output-stream output-file)
           report (. (XDocReportRegistry/getRegistry) loadReport in TemplateEngineKind/Velocity)
           fields-metadata (.createFieldsMetadata report)
           context (. report createContext)]
       (doseq [col columns]
         (.addFieldAsList fields-metadata col))
       (.setFieldsMetadata report fields-metadata)
       (doseq [[k v] context-map]
         (if (seq? v)
           (. context (put (name k) (list-of-maps->java v)))
           (. context (put (name k) v))))
       (. report process context out)))
  ([input-file output-file context-map]
     (merge-doc input-file output-file [] context-map)))
