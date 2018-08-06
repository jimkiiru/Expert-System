
(deftemplate LessionLeaves (slot lessionLeaves))
(deftemplate SmallPots (slot smallPots))
(deftemplate MottlingLeaves (slot mottlingLeaves))
(deftemplate StutedPlants (slot stutedPlants))
(deftemplate TerminalBud (slot terminalBud))
(deftemplate SmallerLeaflets (slot smallerLeaflets))
(deftemplate BrownPatches (slot brownPatches))
(deftemplate SunburnedLeaves (slot sunburnedLeaves))
(deftemplate RedbrownSpots (slot redbrownSpots))
(deftemplate GreenSpots (slot greenSpots))
(deftemplate IrregularSpots (slot irregularSpots))
(deftemplate LeavesWilting (slot leavesWilting))
(deftemplate LeavesScorching (slot leavesScorching))
(deftemplate RustyPatches (slot rustyPatches))
(deftemplate DarkBrownSpots (slot darkBrownSpots))
(deftemplate LeavesDrop (slot leavesDrop))
(deftemplate PuckeredLeaf (slot puckeredLeaf))

(deftemplate Diagnosis (slot diagnosis))
(deftemplate Treatment (slot treatment))

(defrule GetLessionLeaves
   =>
   (bind ?response (read))
   (assert (LessionLeaves (lessionLeaves ?response))))

(defrule GetSmallPots
   =>  
   (bind ?response (read))
   (assert (SmallPots (smallPots ?response))))

(defrule GetMottlingLeaves
   =>
   (bind ?response (read))
   (assert (MottlingLeaves (mottlingLeaves ?response))))

(defrule GetStutedPlants
   => 
   (bind ?response (read))
   (assert (StutedPlants (stutedPlants ?response))))

(defrule GetTerminalBud
   =>
   (bind ?response (read))
   (assert (TerminalBud (terminalBud ?response))))

(defrule GetSmallerLeaflets
   => 
   (bind ?response (read))
   (assert (SmallerLeaflets (smallerLeaflets ?response))))

(defrule GetBrownPatches
   =>
   (bind ?response (read))
   (assert (BrownPatches (brownPatches ?response))))
   
(defrule GetSunburnedLeaves
   =>
   (bind ?response (read))
   (assert (SunburnedLeaves (sunburnedLeaves ?response))))

(defrule GetRedbrownSpots
   =>  
   (bind ?response (read))
   (assert (RedbrownSpots (redbrownSpots ?response))))

(defrule GetGreenSpots
   =>
   (bind ?response (read))
   (assert (GreenSpots (greenSpots ?response))))

(defrule GetIrregularSpots
   => 
   (bind ?response (read))
   (assert (IrregularSpots (irregularSpots ?response))))

(defrule GetLeavesWilting
   =>
   (bind ?response (read))
   (assert (LeavesWilting (leavesWilting ?response))))

(defrule GetLeavesScorching
   => 
   (bind ?response (read))
   (assert (LeavesScorching (leavesScorching ?response))))

(defrule GetRustyPatches
   =>
   (bind ?response (read))
   (assert (RustyPatches (rustyPatches ?response))))

(defrule GetDarkBrownSpots
   =>
   (bind ?response (read))
   (assert (DarkBrownSpots (darkBrownSpots ?response))))

(defrule GetLeavesDrop
   => 
   (bind ?response (read))
   (assert (LeavesDrop (leavesDrop ?response))))

(defrule GetPuckeredLeaf
   => 
   (bind ?response (read))
   (assert (PuckeredLeaf (puckeredLeaf ?response))))

(defrule BacterialBlight
   (LessionLeaves (lessionLeaves yes))
   (SmallPots (smallPots yes)) 
   =>
   (assert (Diagnosis (diagnosis "Bacterial Blight")))
   (printout t "BacterialBlight diagnosed" crlf))

(defrule BeanPodMottle 
   (MottlingLeaves (mottlingLeaves yes))         
   =>
   (assert (Diagnosis (diagnosis "Bean Pod Mottle")))
   (printout t "BeanPodMottle" crlf))
      
(defrule BudBlight  
   (StutedPlants (stutedPlants yes))
   (TerminalBud (terminalBud yes))
   (SmallerLeaflets (smallerLeaflets yes))
   (BrownPatches (brownPatches yes))  
   =>
   (assert (Diagnosis (diagnosis "Bud Blight")))
   (printout t "Dryrot diagnosed" crlf))

(defrule CercosporaLeafBlight
   (SunburnedLeaves (sunburnedLeaves yes))
   (RedbrownSpots (redbrownSpots yes))          
   =>
   (assert (Diagnosis (diagnosis "Cercospora Leaf Blight")))
   (printout t "CercosporaLeafBlight diagnosed" crlf))

 (defrule DownyMildew 
   (GreenSpots (greenSpots yes))          
   =>
   (assert (Diagnosis (diagnosis "Downy Mildew")))
   (printout t "Pinkrot" crlf))
   
(defrule FrogeyeLeafSpot
   (IrregularSpots (irregularSpots yes))
   (LeavesWilting (leavesWilting yes))          
   =>
   (assert (Diagnosis (diagnosis "Frogeye Leaf Spot")))
   (printout t "FrogeyeLeafSpot" crlf))
   
(defrule PowderyMildew
   (LeavesScorching (leavesScorching yes))
   (RustyPatches (rustyPatches yes))         
   =>
   (assert (Diagnosis (diagnosis "Powdery Mildew")))
   (printout t "Rubberyrot" crlf))
   
(defrule SeptoriaBrownSpot
   (DarkBrownSpots (darkBrownSpots yes))
   (LeavesDrop (leavesDrop yes))         
   =>
   (assert (Diagnosis (diagnosis "Septoria Brown Spot")))
   (printout t "Northern Corn Leaf Blight" crlf))   
   
 (defrule SoybeanMosaic
   (StutedPlants (stutedPlants yes))
   (PuckeredLeaf (puckeredLeaf yes))
   (MottlingLeaves (mottlingLeaves yes))         
   =>
   (assert (Diagnosis (diagnosis "Soybean Mosaic")))
   (printout t "Northern Corn Leaf Spot" crlf))  
      
(defrule SoybeanRust 
   (RedbrownSpots (redbrownSpots yes))         
   =>
   (assert (Diagnosis (diagnosis "Soybean Rust")))
   (printout t "SoybeanRust" crlf))   

