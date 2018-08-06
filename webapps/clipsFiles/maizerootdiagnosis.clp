
(deftemplate SlowGrowth (slot slowGrowth))
(deftemplate YellowLeaves (slot yellowLeaves))
(deftemplate LeavesDie (slot leavesDie))
(deftemplate BrownishLesions (slot brownishLesions))
(deftemplate BleachedLeaf (slot bleachedLeaf))
(deftemplate VascularDiscoloration (slot vascularDiscoloration))
(deftemplate NutrientDeficiency (slot nutrientDeficiency))
(deftemplate Wilting (slot wilting))
(deftemplate ShortRoots (slot shortRoots))
(deftemplate StubbyRoots (slot stubbyRoots))
(deftemplate DarkLessions (slot darkLessions))

(deftemplate Diagnosis (slot diagnosis))
(deftemplate Treatment (slot treatment))

(defrule GetSlowGrowth
   =>
   (bind ?response (read))
   (assert (SlowGrowth (slowGrowth ?response))))

(defrule GetYellowLeaves
   =>  
   (bind ?response (read))
   (assert (YellowLeaves (yellowLeaves ?response))))

(defrule GetLeavesDie
   =>
   (bind ?response (read))
   (assert (LeavesDie (leavesDie ?response))))

(defrule GetBrownishLesions
   => 
   (bind ?response (read))
   (assert (BrownishLesions (brownishLesions ?response))))

(defrule GetBleachedLeaf
   =>
   (bind ?response (read))
   (assert (BleachedLeaf (bleachedLeaf ?response))))

(defrule GetVascularDiscoloration
   => 
   (bind ?response (read))
   (assert (VascularDiscoloration (vascularDiscoloration ?response))))

(defrule GetNutrientDeficiency
   =>
   (bind ?response (read))
   (assert (NutrientDeficiency (nutrientDeficiency ?response))))
   
(defrule GetWilting
   =>
   (bind ?response (read))
   (assert (Wilting (wilting ?response))))

(defrule GetShortRoots
   =>  
   (bind ?response (read))
   (assert (ShortRoots (shortRoots ?response))))

(defrule GetStubbyRoots
   =>
   (bind ?response (read))
   (assert (StubbyRoots (stubbyRoots ?response))))

(defrule GetDarkLessions
   => 
   (bind ?response (read))
   (assert (DarkLessions (darkLessions ?response))))

(defrule CornNematodes
   (NutrientDeficiency (nutrientDeficiency yes))
   (Wilting (wilting yes))
   (ShortRoots (shortRoots yes))
   (StubbyRoots (stubbyRoots yes))
   (DarkLessions (darkLessions yes))  
   =>
   (assert (Diagnosis (diagnosis "Corn Nematodes")))
   (printout t "CornNematodes diagnosed" crlf))

(defrule StewartWilt
   (BleachedLeaf (bleachedLeaf yes))
   (VascularDiscoloration (vascularDiscoloration yes))        
   =>
   (assert (Diagnosis (diagnosis "Stewart Wilt")))
   (printout t "StewartWilt diagnosed" crlf))

(defrule RootRot
   (SlowGrowth (slowGrowth yes))
   (YellowLeaves (yellowLeaves yes))
   (LeavesDie (leavesDie yes))
   (BrownishLesions (brownishLesions yes))        
   =>
   (assert (Diagnosis (diagnosis "Root Rot")))
   (printout t "RootRot diagnosed" crlf))
      
      
        