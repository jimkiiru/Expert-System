
(deftemplate RectangularLesions (slot rectangularLesions))
(deftemplate SheathDie (slot sheathDie))

(deftemplate Diagnosis (slot diagnosis))
(deftemplate Treatment (slot treatment))

(defrule GetRectangularLesions
   =>
   (bind ?response (read))
   (assert (RectangularLesions (rectangularLesions ?response))))

(defrule GetSheathDie
   =>  
   (bind ?response (read))
   (assert (SheathDie (sheathDie ?response))))


(defrule StemRot
   (RectangularLesions (rectangularLesions yes))
   (SheathDie (sheathDie yes))
   =>
   (assert (Diagnosis (diagnosis "Stem Rot")))
   (printout t "Stem Rot diagnosed" crlf))

(defrule  ThiophanateMethyl
   (Diagnosis (diagnosis StemRot))
   =>
   (assert (Treatment (treatment "Thiophanate Methyl")))
   (printout t "ThiophanateMethyl prescribed" crlf))
