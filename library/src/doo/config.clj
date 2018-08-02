(ns doo.config
  (:require [clojure.spec.alpha :as s]
            [expound.alpha :as expound]
            [spell-spec.alpha :as spell-spec]
            [spell-spec.expound]))

(s/def ::build string?)
(s/def ::paths (s/map-of keyword? string?))
(s/def ::alias (s/map-of keyword? (s/coll-of keyword?)))

(s/def ::doo (spell-spec/keys :opt-un [::build ::paths ::alias ::karma]))

(defn validate
  "Check that `opts` is valid Doo configuration map. If not, print human-readable errors."
  [opts]
  (expound/expound ::doo opts))
