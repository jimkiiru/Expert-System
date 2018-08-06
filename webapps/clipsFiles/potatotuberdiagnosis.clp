
(deftemplate VascularRing (slot vascularRing))
(deftemplate IrregularBrown (slot irregularBrown))
(deftemplate BrownPatches (slot brownPatches))
(deftemplate IrregularlyShape (slot irregularlyShape))
(deftemplate DiscolouredPatches (slot discolouredPatches))
(deftemplate CrackSurface (slot crackSurface))
(deftemplate RubberyTuber (slot rubberyTuber))
(deftemplate GreySkin (slot greySkin))
(deftemplate LeatherySpots (slot leatherySpots))
(deftemplate SilverySkin (slot silverySkin))
(deftemplate SootyAppearance (slot sootyAppearance))
(deftemplate PurplishPimples (slot purplishPimples))
(deftemplate RaisedSpots (slot raisedSpots))
(deftemplate DarkArcs (slot darkArcs))
(deftemplate CrackedTubers (slot crackedTubers))
(deftemplate DiscolouredTuber (slot discolouredTuber))

(deftemplate Diagnosis (slot diagnosis))
(deftemplate Treatment (slot treatment))

(defrule GetVascularRing
   =>
   (bind ?response (read))
   (assert (VascularRing (vascularRing ?response))))

(defrule GetIrregularBrown
   =>  
   (bind ?response (read))
   (assert (IrregularBrown (irregularBrown ?response))))

(defrule GetBrownPatches
   =>
   (bind ?response (read))
   (assert (BrownPatches (brownPatches ?response))))

(defrule GetIrregularlyShape
   => 
   (bind ?response (read))
   (assert (IrregularlyShape (irregularlyShape ?response))))

(defrule GetDiscolouredPatches
   =>
   (bind ?response (read))
   (assert (DiscolouredPatches (discolouredPatches ?response))))

(defrule GetCrackSurface
   => 
   (bind ?response (read))
   (assert (CrackSurface (crackSurface ?response))))

(defrule GetRubberyTuber
   =>
   (bind ?response (read))
   (assert (RubberyTuber (rubberyTuber ?response))))
   
(defrule GetGreySkin
   =>
   (bind ?response (read))
   (assert (GreySkin (greySkin ?response))))

(defrule GetLeatherySpots
   =>  
   (bind ?response (read))
   (assert (LeatherySpots (leatherySpots ?response))))

(defrule GetSilverySkin
   =>
   (bind ?response (read))
   (assert (SilverySkin (silverySkin ?response))))

(defrule GetSootyAppearance
   => 
   (bind ?response (read))
   (assert (SootyAppearance (sootyAppearance ?response))))

(defrule GetPurplishPimples
   =>
   (bind ?response (read))
   (assert (PurplishPimples (purplishPimples ?response))))

(defrule GetRaisedSpots
   => 
   (bind ?response (read))
   (assert (RaisedSpots (raisedSpots ?response))))

(defrule GetDarkArcs
   =>
   (bind ?response (read))
   (assert (DarkArcs (darkArcs ?response))))

(defrule GetCrackedTubers
   =>
   (bind ?response (read))
   (assert (CrackedTubers (crackedTubers ?response))))

(defrule GetDiscolouredTuber
   => 
   (bind ?response (read))
   (assert (DiscolouredTuber (discolouredTuber ?response))))

(defrule brownrot
   (VascularRing (vascularRing yes)) 
   =>
   (assert (Diagnosis (diagnosis "brown rot")))
   (printout t "brownrot diagnosed" crlf))

(defrule potatoscabs
   (IrregularBrown (irregularBrown yes))         
   =>
   (assert (Diagnosis (diagnosis "potato scabs")))
   (printout t "potatoscabsdiagnosed" crlf))
      
(defrule Dryrot  
   (BrownPatches (brownPatches yes))  
   =>
   (assert (Diagnosis (diagnosis "Dry rot" )))
   (printout t "Dryrot diagnosed" crlf))

(defrule Gangrene
   (IrregularlyShape (irregularlyShape yes))          
   =>
   (assert (Diagnosis (diagnosis "Gangrene")))
   (printout t "Gangrene diagnosed" crlf))

 (defrule Pinkrot 
   (DiscolouredPatches (discolouredPatches yes))          
   =>
   (assert (Diagnosis (diagnosis "Pink rot")))
   (printout t "Pinkrot" crlf))
   
(defrule BacterialRingRot
   (CrackSurface (crackSurface yes))          
   =>
   (assert (Diagnosis (diagnosis "Bacterial Ring Rot")))
   (printout t "BacterialRingRot" crlf))
   
(defrule Rubberyrot
   (RubberyTuber (rubberyTuber yes))
   (GreySkin (greySkin yes))         
   =>
   (assert (Diagnosis (diagnosis "Rubbery rot")))
   (printout t "Rubberyrot" crlf))
   
(defrule SilverScurf
   (LeatherySpots (leatherySpots yes))
   (SilverySkin (silverySkin yes))
   (SootyAppearance (sootyAppearance yes))         
   =>
   (assert (Diagnosis (diagnosis "Silver Scurf")))
   (printout t "Northern Corn Leaf Blight" crlf))   
   
 (defrule SkinSpot
   (PurplishPimples (purplishPimples yes))
   (RaisedSpots (raisedSpots yes))         
   =>
   (assert (Diagnosis (diagnosis "Skin Spot")))
   (printout t "Northern Corn Leaf Spot" crlf))  
      
(defrule Potatomoptopvirus 
   (DarkArcs (darkArcs yes))
   (CrackedTubers (crackedTubers yes))         
   =>
   (assert (Diagnosis (diagnosis "Potato moptop virus")))
   (printout t "Physoderma Brown Spot" crlf))   

(defrule WateryWoundRot
   (DiscolouredTuber (discolouredTuber yes))            
   =>
   (assert (Diagnosis (diagnosis "Watery Wound Rot")))
   (printout t "WateryWoundRot" crlf))
