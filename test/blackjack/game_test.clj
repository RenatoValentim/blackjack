(ns blackjack.game-test
  (:require [clojure.test :refer :all]
            [blackjack.game :refer [get-new-card]]))

(deftest get-new-card-test
  (testing "Should get a new card on a valid range of numbers"
    (is (> 13 (get-new-card)))))
