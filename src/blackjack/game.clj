(ns blackjack.game)

(defn new-card []
  (inc (rand-int 13)))

(defn make-player [name]
  (let [card-1 new-card card-2 new-card]
    {:name name :cards [card-1 card-2]}))
