
(deftemplate ShinyStalk (slot shinyStalk))
(deftemplate BlackStalk (slot blackStalk))
(deftemplate RottedInternodes (slot rottedInternodes))
(deftemplate BlackDiscoloration (slot blackDiscoloration))
(deftemplate BlackSpecks (slot blackSpecks))
(deftemplate ShreddedTissue (slot shreddedTissue))
(deftemplate VascularBundles (slot vascularBundles))
(deftemplate StalkSurface (slot stalkSurface))
(deftemplate InfectionSite (slot infectionSite))
(deftemplate TwistedStalk (slot twistedStalk))
(deftemplate PinkRootsystem (slot pinkRootsystem))
(deftemplate RootMass (slot rootMass))

(deftemplate Diagnosis (slot diagnosis))
(deftemplate Treatment (slot treatment))

(defrule GetShinyStalk
   =>
   (bind ?response (read))
   (assert (ShinyStalk (shinyStalk ?response))))

(defrule GetBlackStalk
   =>  
   (bind ?response (read))
   (assert (BlackStalk (blackStalk ?response))))

(defrule GetRottedInternodes
   =>
   (bind ?response (read))
   (assert (RottedInternodes (rottedInternodes ?response))))

(defrule GetBlackDiscoloration
   => 
   (bind ?response (read))
   (assert (BlackDiscoloration (blackDiscoloration ?response))))

(defrule GetBlackSpecks
   =>
   (bind ?response (read))
   (assert (BlackSpecks (blackSpecks ?response))))

(defrule GetShreddedTissue
   => 
   (bind ?response (read))
   (assert (ShreddedTissue (shreddedTissue ?response))))

(defrule GetVascularBundles
   =>
   (bind ?response (read))
   (assert (VascularBundles (vascularBundles ?response))))
   
(defrule GetStalkSurface
   =>
   (bind ?response (read))
   (assert (StalkSurface (stalkSurface ?response))))

(defrule GetInfectionSite
   =>  
   (bind ?response (read))
   (assert (InfectionSite (infectionSite ?response))))

(defrule GetTwistedStalk
   =>
   (bind ?response (read))
   (assert (TwistedStalk (twistedStalk ?response))))

(defrule GetPinkRootsystem
   => 
   (bind ?response (read))
   (assert (PinkRootsystem (pinkRootsystem ?response))))

(defrule GetRootMass
   => 
   (bind ?response (read))
   (assert (RootMass (rootMass ?response))))

(defrule AnthracnoseStalkRot
   (ShinyStalk (shinyStalk yes))
   (BlackStalk (blackStalk yes))
   (RottedInternodes (rottedInternodes yes))  
   =>
   (assert (Diagnosis (diagnosis "Anthracnose Stalk Rot")))
   (printout t "Anthracnose Stalk Rot diagnosed" crlf))

(defrule CharcoalRot
   (BlackDiscoloration (blackDiscoloration yes))         
   =>
   (assert (Diagnosis (diagnosis "Charcoal Rot")))
   (printout t "CharcoalRot diagnosed" crlf))
      
(defrule DiplodiaStalkrot 
   (BlackSpecks (blackSpecks yes))
   (ShreddedTissue (shreddedTissue yes))  
   =>
   (assert (Diagnosis (diagnosis "Diplodia Stalk rot" )))
   (printout t "DiplodiaStalkrot diagnosed" crlf))

(defrule GibberellaStalkrot
   (VascularBundles (vascularBundles yes))
   (StalkSurface (stalkSurface yes))         
   =>
   (assert (Diagnosis (diagnosis "Gibberella Stalk rot")))
   (printout t "GibberellaStalkrot diagnosed" crlf))

 (defrule PythiumStalkrot
   (InfectionSite (infectionSite yes))
   (TwistedStalk (twistedStalk yes))          
   =>
   (assert (Diagnosis (diagnosis "Pythium Stalk rot")))
   (printout t "PythiumStalkrot" crlf))
   
(defrule RedRootRot
   (PinkRootsystem (pinkRootsystem yes))
   (RootMass (rootMass yes))          
   =>
   (assert (Diagnosis (diagnosis "Red Root Rot")))
   (printout t "RedRootRot" crlf))
   
        