(ns blackjack.game-test
  (:require
   [blackjack.game :refer [make-player new-card]]
   [clojure.test :refer :all]))

(deftest get-new-card-test
  (testing "Should get a new card more or equals 1"
    (is (<= 1 (new-card))))

  (testing "Should get a new card more or equals 13"
    (is (>= 13 (new-card))))

  (testing "Should define a new player"
    (let [player (make-player "John Doe")]
      (is "John Doe" (:name player))
      (is 2 (count (:cards player))))))
