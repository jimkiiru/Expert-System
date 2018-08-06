
(deftemplate RollingLeaves (slot rollingLeaves))
(deftemplate LeatheryLeaves (slot leatheryLeaves))
(deftemplate DeadSpots (slot deadSpots))
(deftemplate StuntingPlant (slot stuntingPlant))
(deftemplate YellowVines (slot yellowVines))
(deftemplate LeafYellowing (slot leafYellowing))
(deftemplate DeadPlants (slot deadPlants))

(deftemplate Diagnosis (slot diagnosis))
(deftemplate Treatment (slot treatment))

(defrule GetRollingLeaves
   =>
   (bind ?response (read))
   (assert (RollingLeaves (rollingLeaves ?response))))

(defrule GetLeatheryLeaves
   =>  
   (bind ?response (read))
   (assert (LeatheryLeaves (leatheryLeaves ?response))))

(defrule GetDeadSpots
   =>
   (bind ?response (read))
   (assert (DeadSpots (deadSpots ?response))))

(defrule GetStuntingPlant
   => 
   (bind ?response (read))
   (assert (StuntingPlant (stuntingPlant ?response))))

(defrule GetYellowVines
   =>
   (bind ?response (read))
   (assert (YellowVines (yellowVines ?response))))

(defrule GetLeafYellowing
   => 
   (bind ?response (read))
   (assert (LeafYellowing (leafYellowing ?response))))

(defrule GetDeadPlants
   =>
   (bind ?response (read))
   (assert (DeadPlants (deadPlants ?response))))
 
(defrule potatoleafrollvirus
   (RollingLeaves (rollingLeaves yes))
   (LeatheryLeaves (leatheryLeaves yes))
   (DeadSpots (deadSpots yes))
   (StuntingPlant (stuntingPlant yes))  
   =>
   (assert (Diagnosis (diagnosis "potato leaf roll virus")))
   (printout t "potatoleafrollvirus diagnosed" crlf))

(defrule VerticilliumWilt
   (YellowVines (yellowVines yes))
   (LeafYellowing (leafYellowing yes))
   (DeadPlants (deadPlants yes))         
   =>
   (assert (Diagnosis (diagnosis "Verticillium Wilt")))
   (printout t "CharcoalRot diagnosed" crlf))
 