;; profile.boot is a script file; it can include any clojure

;; for example, this configures stack trace printing
(alter-var-root
 #'boot.from.io.aviso.exception/*fonts*
 assoc :message boot.from.io.aviso.ansi/white-font)
