(ns blackjack.game-test
  (:require
   [blackjack.game :refer [make-player new-card player-points more-card]]
   [clojure.test :refer :all]))

(deftest get-new-card-test
  (testing "Should get a new card more or equals 1"
    (is (<= 1 (new-card))))

  (testing "Should get a new card more or equals 13"
    (is (>= 13 (new-card)))))

(deftest make-a-new-player-test
  (testing "Should define a new player"
    (let [player (make-player "John Doe")]
      (is (= "John Doe" (:name player)))
      (is (= 2 (count (:cards player)))))))

(deftest calculate-a-player-points-test
  (testing "The cards J(11) Q(12) and K(13) must be worth 10 points"
    (let [points (player-points [11 12 13])]
      (is (= 30 points))))

  (testing "Should change A(1) card to 11 points"
    (let [points (player-points [1 10])]
      (is (= 21 points))))

  (testing "Should to maintain A(1) card to 1 points"
    (let [points (player-points [1 5 7])]
      (is (= 13 points)))))

(deftest get-more-cards-test
  (testing "Should get more cards"
    (let [player (make-player "John Doe")]
      (let [updated-player (more-card player)]
        (is (> (:points updated-player) (:points player)))
        (is (= "John Doe" (:name updated-player)))
        (is (> (count (:cards updated-player)) 2))))))
