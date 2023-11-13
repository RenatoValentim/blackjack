(ns blackjack.game)

(defn new-card []
  (inc (rand-int 13)))

(defn JQK->10 [card]
  (if (> card 10) 10 card))

(defn A->11 [card]
  (if (= card 1) 11 card))

(defn player-points [cards]
  (let [cards-without-JQK (map JQK->10 cards)
        cards-with-A11 (map A->11 cards-without-JQK)
        points-with-A1 (reduce + cards-without-JQK)
        points-with-A11 (reduce + cards-with-A11)]
    (if (> points-with-A11 21) points-with-A1 points-with-A11)))

(defn make-player [name]
  (let [card-1 (new-card)
        card-2 (new-card)
        cards [card-1 card-2]
        points (player-points cards)]
    {:name name
     :cards cards
     :points  points}))
