(ns blackjack.game-test
  (:require
   [blackjack.game :refer [make-player new-card player-points]]
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
      (is (= 30 points)))))
