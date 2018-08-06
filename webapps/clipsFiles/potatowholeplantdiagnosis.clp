
(deftemplate DarkLessions (slot darkLessions))
(deftemplate RoundLeafspot (slot roundLeafspot))
(deftemplate YellowLeaves (slot yellowLeaves))
(deftemplate DarkTubers (slot darkTubers))
(deftemplate CorkyTissue (slot corkyTissue))
(deftemplate ShrivelledLeaves (slot shrivelledLeaves))
(deftemplate IrregularOlive (slot irregularOlive))
(deftemplate PowderyFungalgrowth (slot powderyFungalgrowth))
(deftemplate PurpleLesions (slot purpleLesions))
(deftemplate ReddishDryrot (slot reddishDryrot))
(deftemplate ElongatedLesions (slot elongatedLesions))
(deftemplate LeavesWilt (slot leavesWilt))
(deftemplate FluffyFungalgrowth (slot fluffyFungalgrowth))
(deftemplate IrregularPatches (slot irregularPatches))
(deftemplate BlackDots (slot blackDots))
(deftemplate SlimyLesions (slot slimyLesions))
(deftemplate StuntedPlant (slot stuntedPlant))
(deftemplate RottedTuberflesh (slot rottedTuberflesh))
(deftemplate GrayFlakygrowth (slot grayFlakygrowth))
(deftemplate BrownDryspots (slot brownDryspots))
(deftemplate HardBlackspots (slot hardBlackspots))
(deftemplate DeformedTubers (slot deformedTubers))
(deftemplate GreenTubers (slot greenTubers))
(deftemplate MottledStems (slot mottledStems))
(deftemplate YellowRings (slot yellowRings))
(deftemplate BrownRings (slot brownRings))
(deftemplate CrackedTubers (slot crackedTubers))

(deftemplate Diagnosis (slot diagnosis))
(deftemplate Treatment (slot treatment))

(defrule GetDarkLessions
   =>  
   (bind ?response (read))
   (assert (DarkLessions (darkLessions ?response))))

(defrule GetRoundLeafspot
   =>
   (bind ?response (read))
   (assert (RoundLeafspot (roundLeafspot ?response))))

(defrule GetYellowLeaves
   => 
   (bind ?response (read))
   (assert (YellowLeaves (yellowLeaves ?response))))

(defrule GetDarkTubers
   => 
   (bind ?response (read))
   (assert (DarkTubers (darkTubers ?response))))

(defrule GetCorkyTissue
   =>
   (bind ?response (read))
   (assert (CorkyTissue (corkyTissue ?response))))
   
(defrule GetShrivelledLeaves
   =>
   (bind ?response (read))
   (assert (ShrivelledLeaves (shrivelledLeaves ?response))))

(defrule GetIrregularOlive
   =>  
   (bind ?response (read))
   (assert (IrregularOlive (irregularOlive ?response))))

(defrule GetPowderyFungalgrowth
   =>
   (bind ?response (read))
   (assert (PowderyFungalgrowth (powderyFungalgrowth ?response))))

(defrule GetPurpleLesions
   => 
   (bind ?response (read))
   (assert (PurpleLesions (purpleLesions ?response))))

(defrule GetReddishDryrot
   =>
   (bind ?response (read))
   (assert (ReddishDryrot (reddishDryrot ?response))))

(defrule GetElongatedLesions
   => 
   (bind ?response (read))
   (assert (ElongatedLesions (elongatedLesions ?response))))

(defrule GetLeavesWilt
   =>
   (bind ?response (read))
   (assert (LeavesWilt (leavesWilt ?response))))

(defrule GetFluffyFungalgrowth
   =>
   (bind ?response (read))
   (assert (FluffyFungalgrowth (fluffyFungalgrowth ?response))))

(defrule GetIrregularPatches
   => 
   (bind ?response (read))
   (assert (IrregularPatches (irregularPatches ?response))))

(defrule GetBlackDots
   => 
   (bind ?response (read))
   (assert (BlackDots (blackDots ?response))))

(defrule GetSlimyLesions
   =>
   (bind ?response (read))
   (assert (SlimyLesions (slimyLesions ?response))))

(defrule GetStuntedPlant
   => 
   (bind ?response (read))
   (assert (StuntedPlant (stuntedPlant ?response))))

(defrule GetRottedTuberflesh
   => 
   (bind ?response (read))
   (assert (RottedTuberflesh (rottedTuberflesh ?response))))

(defrule GetGrayFlakygrowth
   =>
   (bind ?response (read))
   (assert (GrayFlakygrowth (grayFlakygrowth ?response))))

(defrule GetBrownDryspots
   =>
   (bind ?response (read))
   (assert (BrownDryspots (brownDryspots ?response))))

(defrule GetHardBlackspots
   => 
   (bind ?response (read))
   (assert (HardBlackspots (hardBlackspots ?response))))

(defrule GetDeformedTubers
   => 
   (bind ?response (read))
   (assert (DeformedTubers (deformedTubers ?response))))

(defrule GetGreenTubers
   =>
   (bind ?response (read))
   (assert (GreenTubers (greenTubers ?response))))

(defrule GetMottledStems
   => 
   (bind ?response (read))
   (assert (MottledStems (mottledStems ?response))))

(defrule GetYellowRings
   =>
   (bind ?response (read))
   (assert (YellowRings (yellowRings ?response))))

(defrule GetBrownRings
   =>
   (bind ?response (read))
   (assert (BrownRings (brownRings ?response))))

(defrule GetCrackedTubers
   => 
   (bind ?response (read))
   (assert (CrackedTubers (crackedTubers ?response))))

(defrule EarlyBlight 
   (DarkLessions (darkLessions yes))
   (RoundLeafspot (roundLeafspot yes))
   (YellowLeaves (yellowLeaves yes))
   (DarkTubers (darkTubers yes))
   (CorkyTissue (corkyTissue yes)) 
   =>
   (assert (Diagnosis (diagnosis "Early Blight")))
   (printout t "Early Blight diagnosed" crlf))

(defrule LateBlight
   (ShrivelledLeaves (shrivelledLeaves yes))
   (IrregularOlive (irregularOlive yes))
   (PowderyFungalgrowth (powderyFungalgrowth yes))
   (PurpleLesions (purpleLesions yes))
   (ReddishDryrot (reddishDryrot yes))         
   =>
   (assert (Diagnosis (diagnosis "Late Blight")))
   (printout t "Late Blight" crlf))
      
(defrule WhiteMold  
   (ElongatedLesions (elongatedLesions yes))
   (LeavesWilt (leavesWilt yes))
   (FluffyFungalgrowth (fluffyFungalgrowth yes))  
   =>
   (assert (Diagnosis (diagnosis "White Mold" )))
   (printout t "White Mold diagnosed" crlf))

(defrule BlackDot
   (DarkLessions (darkLessions yes))
   (IrregularPatches (irregularPatches yes))
   (BlackDots (blackDots yes))
   (LeavesWilt (leavesWilt yes))          
   =>
   (assert (Diagnosis (diagnosis "Black Dot")))
   (printout t "Black Dot diagnosed" crlf))

 (defrule Blackleg 
   (SlimyLesions (slimyLesions yes))
   (StuntedPlant (stuntedPlant yes))
   (RottedTuberflesh (rottedTuberflesh yes))         
   =>
   (assert (Diagnosis (diagnosis "Blackleg")))
   (printout t "Blackleg & Soft Rot " crlf))
   
(defrule BlackScurf
   (GrayFlakygrowth (grayFlakygrowth yes))
   (BrownDryspots (brownDryspots yes))
   (HardBlackspots (hardBlackspots yes))
   (DeformedTubers (deformedTubers yes))
   (GreenTubers (greenTubers yes))          
   =>
   (assert (Diagnosis (diagnosis "Black Scurf")))
   (printout t "Black Scurf" crlf))
   
(defrule CorkyRingSpot 
   (MottledStems (mottledStems yes))
   (YellowRings (yellowRings yes))
   (BrownRings (brownRings yes))
   (CrackedTubers (crackedTubers yes))         
   =>
   (assert (Diagnosis (diagnosis "Corky Ring Spot")))
   (printout t "Corky Ring Spot " crlf))
