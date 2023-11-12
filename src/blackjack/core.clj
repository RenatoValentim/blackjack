(ns blackjack.core
  (:gen-class)
  (:require
   [blackjack.game :refer [make-player]]
   [card-ascii-art.core :as card-view]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (card-view/print-player (make-player "John Doe")))

(-main)
