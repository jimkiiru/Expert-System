
(deftemplate StuntedStem (slot stuntedStem))
(deftemplate SmallLeaves (slot smallLeaves))
(deftemplate BlackStems (slot blackStems))
(deftemplate VineWilting (slot vineWilting))
(deftemplate BrittleStems (slot brittleStems))
(deftemplate BrownLessions (slot brownLessions))

(deftemplate Diagnosis (slot diagnosis))
(deftemplate Treatment (slot treatment))

(defrule GetStuntedStem
   =>
   (bind ?response (read))
   (assert (StuntedStem (stuntedStem ?response))))

(defrule GetSmallLeaves
   =>  
   (bind ?response (read))
   (assert (SmallLeaves (smallLeaves ?response))))

(defrule GetBlackStems
   =>
   (bind ?response (read))
   (assert (BlackStems (blackStems ?response))))

(defrule GetVineWilting
   => 
   (bind ?response (read))
   (assert (VineWilting (vineWilting ?response))))

(defrule GetBrittleStems
   =>
   (bind ?response (read))
   (assert (BrittleStems (brittleStems ?response))))

(defrule GetBrownLessions
   => 
   (bind ?response (read))
   (assert (BrownLessions (brownLessions ?response))))

(defrule blackleg
   (StuntedStem (stuntedStem yes))
   (SmallLeaves (smallLeaves yes))
   (BlackStems (blackStems yes))  
   =>
   (assert (Diagnosis (diagnosis "black leg")))
   (printout t "blackleg diagnosed" crlf))

(defrule WhiteMold
   (VineWilting (vineWilting yes))
   (BrittleStems (brittleStems yes))         
   =>
   (assert (Diagnosis (diagnosis "White Mold")))
   (printout t "WhiteMold diagnosed" crlf))
 
(defrule Lateblight
   (BrownLessions (brownLessions yes))         
   =>
   (assert (Diagnosis (diagnosis "Late blight")))
   (printout t "Lateblight diagnosed" crlf))
 