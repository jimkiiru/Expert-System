
(deftemplate VascularSystem (slot vascularSystem))
(deftemplate GrayTaproot (slot grayTaproot))
(deftemplate Epidermis (slot epidermis))
(deftemplate BruisedStems (slot bruisedStems))
(deftemplate RootLesions (slot rootLesions))
(deftemplate WiltingLeaves (slot wiltingLeaves))
(deftemplate RaisedDots (slot raisedDots))
(deftemplate SunburnedLeaves (slot sunburnedLeaves))
(deftemplate BlackSclerotia (slot blackSclerotia))
(deftemplate BrownDiscoloration (slot brownDiscoloration))
(deftemplate TinyblackDots (slot tinyblackDots))

(deftemplate Diagnosis (slot diagnosis))
(deftemplate Treatment (slot treatment))

(defrule GetVascularSystem
   =>
   (bind ?response (read))
   (assert (VascularSystem (vascularSystem ?response))))

(defrule GetGrayTaproot
   =>  
   (bind ?response (read))
   (assert (GrayTaproot (grayTaproot ?response))))

(defrule GetEpidermis
   =>
   (bind ?response (read))
   (assert (Epidermis (epidermis ?response))))

(defrule GetBruisedStems
   => 
   (bind ?response (read))
   (assert (BruisedStems (bruisedStems ?response))))

(defrule GetRootLesions
   =>
   (bind ?response (read))
   (assert (RootLesions (rootLesions ?response))))

(defrule GetWiltingLeaves
   => 
   (bind ?response (read))
   (assert (WiltingLeaves (wiltingLeaves ?response))))

(defrule GetRaisedDots
   =>
   (bind ?response (read))
   (assert (RaisedDots (raisedDots ?response))))
   
(defrule GetSunburnedLeaves
   =>
   (bind ?response (read))
   (assert (SunburnedLeaves (sunburnedLeaves ?response))))

(defrule GetBlackSclerotia
   =>  
   (bind ?response (read))
   (assert (BlackSclerotia (blackSclerotia ?response))))

(defrule GetBrownDiscoloration
   =>
   (bind ?response (read))
   (assert (BrownDiscoloration (brownDiscoloration ?response))))

(defrule GetTinyblackDots
   => 
   (bind ?response (read))
   (assert (TinyblackDots (tinyblackDots ?response))))

(defrule BrownStemRot 
   (VascularSystem (vascularSystem yes)) 
   =>
   (assert (Diagnosis (diagnosis "Brown Stem Rot")))
   (printout t "BrownStemRot diagnosed" crlf))

(defrule CharcoalRot 
   (GrayTaproot (grayTaproot yes))
   (Epidermis (epidermis yes))         
   =>
   (assert (Diagnosis (diagnosis "Charcoal Rot")))
   (printout t "CharcoalRot" crlf))
      
(defrule PhytophthoraRot  
   (BruisedStems (bruisedStems yes))
   (RootLesions (rootLesions yes))
   (WiltingLeaves (wiltingLeaves yes))  
   =>
   (assert (Diagnosis (diagnosis "Phytophthora Rot")))
   (printout t "PhytophthoraRot diagnosed" crlf))

(defrule StemBlight
   (RaisedDots (raisedDots yes))          
   =>
   (assert (Diagnosis (diagnosis "Stem Blight")))
   (printout t "StemBlight diagnosed" crlf))

 (defrule PurpleSeedStain  
   (SunburnedLeaves (sunburnedLeaves yes))          
   =>
   (assert (Diagnosis (diagnosis "Purple Seed Stain")))
   (printout t "PurpleSeedStain" crlf))
   
(defrule SclerotiniaStemRot 
   (BlackSclerotia (blackSclerotia yes))          
   =>
   (assert (Diagnosis (diagnosis "Sclerotinia Stem Rot")))
   (printout t "SclerotiniaStemRot" crlf))
   
(defrule StemCanker
   (BrownDiscoloration (brownDiscoloration yes))
   (TinyblackDots (tinyblackDots yes))         
   =>
   (assert (Diagnosis (diagnosis "Stem Canker")))
   (printout t "StemCanker" crlf))
   
