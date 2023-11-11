(ns blackjack.game-test
  (:require [clojure.test :refer :all]
            [blackjack.game :refer [new-card]]))

(deftest get-new-card-test
  (testing "Should get a new card more or equals 1"
    (is (<= 1 (new-card))))

  (testing "Should get a new card more or equals 13"
    (is (>= 13 (new-card)))))
