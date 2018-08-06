
(deftemplate Specks (slot specks))
(deftemplate Spots (slot spots))
(deftemplate Wilt (slot wilt))
(deftemplate YellowishStripes (slot yellowishStripes))
(deftemplate BacterialOoze (slot bacterialOoze))
(deftemplate YellowLessions (slot yellowLessions))
(deftemplate SheathDiscoloration (slot sheathDiscoloration))
(deftemplate IrregularSpots (slot irregularSpots))
(deftemplate LesionsEnlarge (slot lesionsEnlarge))
(deftemplate UnemergedPaniclesrot (slot unemergedPaniclesrot))
(deftemplate WhitishPowdery (slot whitishPowdery))
(deftemplate InfectedPaniclesSterile (slot infectedPaniclesSterile))
(deftemplate TranslucentStreaks (slot translucentStreaks))
(deftemplate BrownLesions (slot brownLesions))


(deftemplate Diagnosis (slot diagnosis))
(deftemplate Treatment (slot treatment))

(defrule GetSpecks
   =>
   (bind ?response (read))
   (assert (Specks (specks ?response))))

(defrule GetSpots
   =>  
   (bind ?response (read))
   (assert (Spots (spots ?response))))

(defrule GetWilt
   =>
   (bind ?response (read))
   (assert (Wilt (wilt ?response))))

(defrule GetYellowishStripes
   => 
   (bind ?response (read))
   (assert (YellowishStripes (yellowishStripes ?response))))

(defrule GetBacterialOoze
   =>
   (bind ?response (read))
   (assert (BacterialOoze (bacterialOoze ?response))))

(defrule GetYellowLessions
   =>
   (bind ?response (read))
   (assert (YellowLessions (yellowLessions ?response))))

(defrule GetSheathDiscoloration
   => 
   (bind ?response (read))
   (assert (SheathDiscoloration (sheathDiscoloration ?response))))

(defrule GetIrregularSpots
   =>
   (bind ?response (read))
   (assert (IrregularSpots (irregularSpots ?response))))

(defrule GetLesionsEnlarge
   =>
   (bind ?response (read))
   (assert (LesionsEnlarge (lesionsEnlarge ?response))))

(defrule GetUnemergedPaniclesrot
   =>
   (bind ?response (read))
   (assert (UnemergedPaniclesrot (unemergedPaniclesrot ?response))))

(defrule GetWhitishPowdery
   =>
   (bind ?response (read))
   (assert (WhitishPowdery (whitishPowdery ?response))))

(defrule GetInfectedPaniclesSterile
   =>
   (bind ?response (read))
   (assert (InfectedPaniclesSterile (infectedPaniclesSterile ?response))))

(defrule GetTranslucentStreaks
   =>
   (bind ?response (read))
   (assert (TranslucentStreaks (translucentStreaks ?response))))

(defrule GetBrownLesions
   =>
   (bind ?response (read))
   (assert (BrownLesions (brownLesions ?response))))



(defrule Blast
   (Specks (specks yes))
   (Spots (spots yes))
   =>
   (assert (Diagnosis (diagnosis "Blast")))
   (printout t "Blast diagnosed" crlf))

(defrule BacterialLeafBlight
   (Wilt (wilt yes))
   (YellowishStripes (yellowishStripes yes))          
   (BacterialOoze (bacterialOoze yes))
   (YellowLessions (yellowLessions yes))
   =>
   (assert (Diagnosis (diagnosis "Bacterial Leaf Blight")))
   (printout t "BacterialLeafBlight diagnosed" crlf))   

(defrule SheathRot
   (SheathDiscoloration (sheathDiscoloration yes))
   (IrregularSpots (irregularSpots yes))
   (LesionsEnlarge (lesionsEnlarge yes))
   (UnemergedPaniclesrot (unemergedPaniclesrot yes))
   (WhitishPowdery (whitishPowdery yes))
   (InfectedPaniclesSterile (infectedPaniclesSterile yes))
   =>
   (assert (Diagnosis (diagnosis "Sheath Rot")))
   (printout t "Sheath Rot diagnosed" crlf))

(defrule Leafstreak
   (TranslucentStreaks (translucentStreaks yes))
   (BrownLesions (brownLesions yes))
   =>
   (assert (Diagnosis (diagnosis "Leaf streak")))
   (printout t "Leaf streak diagnosed" crlf))
   
(defrule  LeafSpot
   (Spots (spots yes))
   =>
   (assert (Diagnosis (diagnosis "Leaf Spot")))
   (printout t "Leaf Spot diagnosed" crlf))   



(defrule SprayCarbendazim 
   (Diagnosis (diagnosis Blast))
   =>
   (assert (Treatment (treatment SprayCarbendazim )))
   (printout t "Spray Carbendazim  prescribed" crlf))

(defrule Sprayfreshcowdung
   (Diagnosis (diagnosis BacterialLeafBlight))
   =>
   (assert (Treatment (treatment Sprayfreshcowdung)))
   (printout t "Spray fresh cowdung prescribed" crlf))

(defrule ApplyGypsum
   (Diagnosis (diagnosis SheathRot))
   =>
   (assert (Treatment (treatment ApplyGypsum)))
   (printout t "Apply Gypsum prescribed" crlf))
   
 (defrule Copperhydroxide
   (Diagnosis (diagnosis Leafstreak))
   =>
   (assert (Treatment (treatment Copperhydroxide)))
   (printout t "Copperhydroxide prescribed" crlf))  

(defrule Metominostrobin
   (Diagnosis (diagnosis  LeafSpot))
   =>
   (assert (Treatment (treatment Metominostrobin)))
   (printout t "Metominostrobin prescribed" crlf))
