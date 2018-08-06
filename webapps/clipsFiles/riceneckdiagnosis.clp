
(deftemplate BlackColor (slot blackColor))
(deftemplate NeckBreaks (slot neckBreaks))

(deftemplate Diagnosis (slot diagnosis))
(deftemplate Treatment (slot treatment))

(defrule GetBlackColor
   =>
   (bind ?response (read))
   (assert (BlackColor (blackColor ?response))))

(defrule GetNeckBreaks
   =>  
   (bind ?response (read))
   (assert (NeckBreaks (neckBreaks ?response))))


(defrule NeckBlast
   (BlackColor (blackColor yes))
   (NeckBreaks (neckBreaks yes))
   =>
   (assert (Diagnosis (diagnosis "Neck Blast")))
   (printout t "Neck Blast diagnosed" crlf))

(defrule  SprayCarbendazim
   (Diagnosis (diagnosis NeckBlast))
   =>
   (assert (Treatment (treatment SprayCarbendazim)))
   (printout t "Spray Carbendazim prescribed" crlf))
