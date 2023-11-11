(ns blackjack.game)

(defn new-card []
  (inc (rand-int 13)))
