
(deftemplate SlowGrowth (slot slowGrowth))
(deftemplate YellowLeaves (slot yellowLeaves))
(deftemplate LeavesDie (slot leavesDie))
(deftemplate DarkRoots (slot darkRoots))
(deftemplate LimpRoots (slot limpRoots))

(deftemplate Diagnosis (slot diagnosis))
(deftemplate Treatment (slot treatment))

(defrule GetSlowGrowth
   =>
   (bind ?response (read))
   (assert (SlowGrowth (slowGrowth ?response))))

(defrule GetYellowLeavesg
   =>  
   (bind ?response (read))
   (assert (YellowLeaves (yellowLeaves ?response))))

(defrule GetLeavesDie
   =>
   (bind ?response (read))
   (assert (LeavesDie (leavesDie ?response))))

(defrule GetDarkRoots
   => 
   (bind ?response (read))
   (assert (DarkRoots (darkRoots ?response))))

(defrule GetLimpRoots
   =>
   (bind ?response (read))
   (assert (LimpRoots (limpRoots ?response))))

(defrule RootRot
   (SlowGrowth (slowGrowth yes))
   (YellowLeaves (yellowLeaves yes))
   (LeavesDie (leavesDie yes))
   (DarkRoots (darkRoots yes))
   (LimpRoots (limpRoots yes))
   =>
   (assert (Diagnosis (diagnosis "Root Rot")))
   (printout t "Root Rot diagnosed" crlf))

(defrule Fungicide
   (Diagnosis (diagnosis RootRot))
   =>
   (assert (Treatment (treatment "Fungicide")))
   (printout t "fungicide prescribed" crlf))
