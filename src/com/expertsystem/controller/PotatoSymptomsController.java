package com.expertsystem.controller;


import jess.Fact;
import jess.JessException;
import jess.Rete;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.validation.Valid;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.expertsystem.model.*;

@Controller
public class PotatoSymptomsController {

	private static Rete rete;
	@Autowired
	SessionFactory factory;
	
	@RequestMapping(value = "/potatopartsaffected", method = RequestMethod.GET)
	public ModelAndView partsAffected(HttpSession session) {
		ModelAndView mav = new ModelAndView("potatoPartsAffected");
		
		String logid = "" + session.getAttribute("logid");
		int lid = Integer.parseInt(logid);

		Session sess = factory.openSession();

		String username = "";
		Query qrey = sess.createQuery("from LoginModel c where c.logid=:lid");
		qrey.setInteger("lid", lid);
		List l = qrey.list();
		Iterator it = l.iterator();
		while (it.hasNext()) {
			Object o = (Object) it.next();
			LoginModel log = (LoginModel) o;
			username = log.getUsername();
		}
		int farmerId = 0;
		Query qrey1 = sess.createQuery("from FarmerModel c where c.phonenum=:pnum");
		qrey1.setString("pnum", username);
		List l1 = qrey1.list();
		Iterator it1 = l1.iterator();
		while (it1.hasNext()) {
			Object o = (Object) it1.next();
			FarmerModel fm = (FarmerModel) o;
			farmerId = fm.getFarmerId();
		}
		mav.addObject("farmerId", farmerId);
		
		return mav;
	}
	@RequestMapping(value = "/potatoDiagnosisResult", method = RequestMethod.GET)
	public ModelAndView diagnosisResult(@RequestParam("listValue")String listValue,HttpServletRequest request,HttpSession session) {
		ModelAndView mav = new ModelAndView("diagnosisResult");		

		//SessionFactory factory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session sess = factory.openSession();

		Query query = sess.createQuery("from PotatoDiseaseModel r where r.diseaseName=:diag");
		query.setString("diag", listValue);
		List l = query.list();		
		request.setAttribute("list", l);
		
		String logid = "" + session.getAttribute("logid");
		int lid = Integer.parseInt(logid);

		String username = "";
		Query qrey = sess.createQuery("from LoginModel c where c.logid=:lid");
		qrey.setInteger("lid", lid);
		List lF = qrey.list();
		Iterator it = lF.iterator();
		while (it.hasNext()) {
			Object o = (Object) it.next();
			LoginModel log = (LoginModel) o;
			username = log.getUsername();
		}
		int farmerId = 0;
		Query qrey1 = sess.createQuery("from FarmerModel c where c.phonenum=:pnum");
		qrey1.setString("pnum", username);
		List l1 = qrey1.list();
		Iterator it1 = l1.iterator();
		while (it1.hasNext()) {
			Object o = (Object) it1.next();
			FarmerModel fm = (FarmerModel) o;
			farmerId = fm.getFarmerId();
		}
		mav.addObject("farmerId", farmerId);				
				
		return mav;
	}

	@RequestMapping(value = "/potatoleaf", method = RequestMethod.GET)
	public ModelAndView LeafSymptom(HttpSession session) {
		ModelAndView mav = new ModelAndView("potatoLeafSymptom");
		
		String logid = "" + session.getAttribute("logid");
		int lid = Integer.parseInt(logid);

		Session sess = factory.openSession();

		String username = "";
		Query qrey = sess.createQuery("from LoginModel c where c.logid=:lid");
		qrey.setInteger("lid", lid);
		List l = qrey.list();
		Iterator it = l.iterator();
		while (it.hasNext()) {
			Object o = (Object) it.next();
			LoginModel log = (LoginModel) o;
			username = log.getUsername();
		}
		int farmerId = 0;
		Query qrey1 = sess.createQuery("from FarmerModel c where c.phonenum=:pnum");
		qrey1.setString("pnum", username);
		List l1 = qrey1.list();
		Iterator it1 = l1.iterator();
		while (it1.hasNext()) {
			Object o = (Object) it1.next();
			FarmerModel fm = (FarmerModel) o;
			farmerId = fm.getFarmerId();
		}
		mav.addObject("farmerId", farmerId);
		
		PotatoLeafModel leaves = new PotatoLeafModel();
		mav.getModelMap().put("potatoLeafSymptom", leaves);
		return mav;
	}

	@RequestMapping(value = "/potatostem", method = RequestMethod.GET)
	public ModelAndView stemSymptom(HttpSession session) {
		ModelAndView mav = new ModelAndView("potatoStemSymptoms");
		
		String logid = "" + session.getAttribute("logid");
		int lid = Integer.parseInt(logid);

		Session sess = factory.openSession();

		String username = "";
		Query qrey = sess.createQuery("from LoginModel c where c.logid=:lid");
		qrey.setInteger("lid", lid);
		List l = qrey.list();
		Iterator it = l.iterator();
		while (it.hasNext()) {
			Object o = (Object) it.next();
			LoginModel log = (LoginModel) o;
			username = log.getUsername();
		}
		int farmerId = 0;
		Query qrey1 = sess.createQuery("from FarmerModel c where c.phonenum=:pnum");
		qrey1.setString("pnum", username);
		List l1 = qrey1.list();
		Iterator it1 = l1.iterator();
		while (it1.hasNext()) {
			Object o = (Object) it1.next();
			FarmerModel fm = (FarmerModel) o;
			farmerId = fm.getFarmerId();
		}
		mav.addObject("farmerId", farmerId);
		
		PotatoStemModel stem = new PotatoStemModel();
		mav.getModelMap().put("potatoStemSymptoms", stem);
		return mav;
	}

	@RequestMapping(value = "/potatotuber", method = RequestMethod.GET)
	public ModelAndView tuberSymptom(HttpSession session) {
		ModelAndView mav = new ModelAndView("potatoTuberSymptom");
		
		String logid = "" + session.getAttribute("logid");
		int lid = Integer.parseInt(logid);

		Session sess = factory.openSession();

		String username = "";
		Query qrey = sess.createQuery("from LoginModel c where c.logid=:lid");
		qrey.setInteger("lid", lid);
		List l = qrey.list();
		Iterator it = l.iterator();
		while (it.hasNext()) {
			Object o = (Object) it.next();
			LoginModel log = (LoginModel) o;
			username = log.getUsername();
		}
		int farmerId = 0;
		Query qrey1 = sess.createQuery("from FarmerModel c where c.phonenum=:pnum");
		qrey1.setString("pnum", username);
		List l1 = qrey1.list();
		Iterator it1 = l1.iterator();
		while (it1.hasNext()) {
			Object o = (Object) it1.next();
			FarmerModel fm = (FarmerModel) o;
			farmerId = fm.getFarmerId();
		}
		mav.addObject("farmerId", farmerId);
		
		PotatoTuberModel tuber = new PotatoTuberModel();
		mav.getModelMap().put("potatoTuberSymptom", tuber);
		return mav;
	}
	@RequestMapping(value = "/potatowholeplant", method = RequestMethod.GET)
	public ModelAndView wholePlantSymptom(HttpSession session) {
		ModelAndView mav = new ModelAndView("potatoWholePlantSymptom");
		
		String logid = "" + session.getAttribute("logid");
		int lid = Integer.parseInt(logid);

		Session sess = factory.openSession();

		String username = "";
		Query qrey = sess.createQuery("from LoginModel c where c.logid=:lid");
		qrey.setInteger("lid", lid);
		List l = qrey.list();
		Iterator it = l.iterator();
		while (it.hasNext()) {
			Object o = (Object) it.next();
			LoginModel log = (LoginModel) o;
			username = log.getUsername();
		}
		int farmerId = 0;
		Query qrey1 = sess.createQuery("from FarmerModel c where c.phonenum=:pnum");
		qrey1.setString("pnum", username);
		List l1 = qrey1.list();
		Iterator it1 = l1.iterator();
		while (it1.hasNext()) {
			Object o = (Object) it1.next();
			FarmerModel fm = (FarmerModel) o;
			farmerId = fm.getFarmerId();
		}
		mav.addObject("farmerId", farmerId);
		
		PotatoWholePlantModel tuber = new PotatoWholePlantModel();
		mav.getModelMap().put("potatoWholePlantSymptom", tuber);
		return mav;
	}


	@RequestMapping(value = "/potatoLeafDiag", method = RequestMethod.POST)
	public ModelAndView leafDiagnosis(@Valid PotatoLeafModel plm,HttpServletRequest request,HttpSession session) {
		ModelAndView mav = new ModelAndView("potatoDiseasesFound");
		
		String logid = "" + session.getAttribute("logid");
		int lid = Integer.parseInt(logid);

		Session sess = factory.openSession();

		String username = "";
		Query qrey = sess.createQuery("from LoginModel c where c.logid=:lid");
		qrey.setInteger("lid", lid);
		List l = qrey.list();
		Iterator itF = l.iterator();
		while (itF.hasNext()) {
			Object o = (Object) itF.next();
			LoginModel log = (LoginModel) o;
			username = log.getUsername();
		}
		int farmerId = 0;
		Query qrey1 = sess.createQuery("from FarmerModel c where c.phonenum=:pnum");
		qrey1.setString("pnum", username);
		List l1 = qrey1.list();
		Iterator it1 = l1.iterator();
		while (it1.hasNext()) {
			Object o = (Object) it1.next();
			FarmerModel fm = (FarmerModel) o;
			farmerId = fm.getFarmerId();
		}
		mav.addObject("farmerId", farmerId);

		rete = new Rete();
		try {
			rete.batch("C:\\xampp\\tomcat\\webapps\\ExpertSystem\\clipsFiles\\potatoleafdiagnosis.clp");
		} catch (JessException ex) {
			Logger.getLogger(PotatoSymptomsController.class.getName()).log(Level.SEVERE, null,
					ex);
		}

		try {
			rete.assertString("(RollingLeaves (rollingLeaves "+ plm.getRollingLeaves() + "))");
			rete.assertString("(LeatheryLeaves (leatheryLeaves " + plm.getLeatheryLeaves() + "))");
			rete.assertString("(DeadSpots (deadSpots " + plm.getDeadSpots() + "))");
			rete.assertString("(StuntingPlant (stuntingPlant "+ plm.getStuntingPlant() + "))");
			rete.assertString("(YellowVines (yellowVines "+ plm.getYellowVines() + "))");			
			rete.assertString("(LeafYellowing (leafYellowing "+ plm.getLeafYellowing() + "))");
			rete.assertString("(DeadPlants (deadPlants " + plm.getDeadPlants() + "))");
			
			
		} catch (JessException ex) {
			Logger.getLogger(PotatoSymptomsController.class.getName()).log(
					Level.SEVERE, null, ex);
		}
		try {
			rete.executeCommand("(facts)");
		} catch (JessException ex) {
			Logger.getLogger(PotatoSymptomsController.class.getName()).log(
					Level.SEVERE, null, ex);
		}

		List<String> listOfDiseases=new ArrayList<String>();
		float count=0;
		String diagnosis = "";
		try {
			rete.run();
			Iterator it = rete.listFacts();
			Fact faux;

			while (it.hasNext()) {
				faux = (Fact) it.next();
				if (faux.getName().equals("MAIN::Diagnosis")) {
					diagnosis += faux.getSlotValue("diagnosis");
					String withoutQuotes=diagnosis.replace("\"", "");
					listOfDiseases.add(withoutQuotes);
				}
				if (faux.getName().equals("MAIN::RollingLeaves")) {					
					if(faux.getSlotValue("rollingLeaves").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::LeatheryLeaves")) {					
					if(faux.getSlotValue("leatheryLeaves").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::DeadSpots")) {									
					if(faux.getSlotValue("deadSpots").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::StuntingPlant")) {										
					if(faux.getSlotValue("stuntingPlant").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::YellowVines")) {					
					if(faux.getSlotValue("yellowVines").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::LeafYellowing")) {					
					if(faux.getSlotValue("leafYellowing").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::DeadPlants")) {									
					if(faux.getSlotValue("deadPlants").equals("yes")){
						count++;
					}						
				}
				
				diagnosis="";
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		DecimalFormat fmt=new DecimalFormat("0.##");
		List<String> percentList=new ArrayList<String>();
		float percent=0;
		//begin: calculate percent
		for(int i=0;i<listOfDiseases.size();i++){
		if((listOfDiseases.get(i)).equals("potato leaf roll virus")){
			percent=(4/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Verticillium Wilt")){
			percent=(3/count)*100;
			percentList.add(""+fmt.format(percent));
		}				
		}
		//end		
		Map<String,String> map = new HashMap<String,String>();
		for(int i=0;i<listOfDiseases.size();i++){
			map.put(listOfDiseases.get(i), percentList.get(i));
		}
		mav.addObject("count",count);
		request.setAttribute("maps", map);
		
		//mav.addObject("diseases", listOfDiseases);
		return mav;
	}
	
	@RequestMapping(value = "/potatoStemDiag", method = RequestMethod.POST)
	public ModelAndView stemDiagnosis(@Valid PotatoStemModel psm,HttpServletRequest request,HttpSession session) {
		ModelAndView mav = new ModelAndView("potatoDiseasesFound");
		
		String logid = "" + session.getAttribute("logid");
		int lid = Integer.parseInt(logid);

		Session sess = factory.openSession();

		String username = "";
		Query qrey = sess.createQuery("from LoginModel c where c.logid=:lid");
		qrey.setInteger("lid", lid);
		List l = qrey.list();
		Iterator itF = l.iterator();
		while (itF.hasNext()) {
			Object o = (Object) itF.next();
			LoginModel log = (LoginModel) o;
			username = log.getUsername();
		}
		int farmerId = 0;
		Query qrey1 = sess.createQuery("from FarmerModel c where c.phonenum=:pnum");
		qrey1.setString("pnum", username);
		List l1 = qrey1.list();
		Iterator it1 = l1.iterator();
		while (it1.hasNext()) {
			Object o = (Object) it1.next();
			FarmerModel fm = (FarmerModel) o;
			farmerId = fm.getFarmerId();
		}
		mav.addObject("farmerId", farmerId);

		rete = new Rete();
		try {
			rete.batch("C:\\xampp\\tomcat\\webapps\\ExpertSystem\\clipsFiles\\potatostemdiagnosis.clp");
		} catch (JessException ex) {
			Logger.getLogger(PotatoSymptomsController.class.getName()).log(Level.SEVERE, null,
					ex);
		}

		try {
			rete.assertString("(StuntedStem (stuntedStem "+ psm.getStuntedStem() + "))");
			rete.assertString("(SmallLeaves (smallLeaves " + psm.getSmallLeaves() + "))");
			rete.assertString("(BlackStems (blackStems " + psm.getBlackStems() + "))");
			rete.assertString("(VineWilting (vineWilting "+ psm.getVineWilting() + "))");
			rete.assertString("(BrittleStems (brittleStems "+ psm.getBrittleStems() + "))");			
			rete.assertString("(BrownLessions (brownLessions "+ psm.getBrownLessions() + "))");
			
		} catch (JessException ex) {
			Logger.getLogger(PotatoSymptomsController.class.getName()).log(
					Level.SEVERE, null, ex);
		}
		try {
			rete.executeCommand("(facts)");
		} catch (JessException ex) {
			Logger.getLogger(PotatoSymptomsController.class.getName()).log(
					Level.SEVERE, null, ex);
		}

		List<String> listOfDiseases=new ArrayList<String>();
		float count=0;
		String diagnosis = "";
		try {
			rete.run();
			Iterator it = rete.listFacts();
			Fact faux;

			while (it.hasNext()) {
				faux = (Fact) it.next();
				if (faux.getName().equals("MAIN::Diagnosis")) {
					diagnosis += faux.getSlotValue("diagnosis");
					String withoutQuotes=diagnosis.replace("\"", "");
					listOfDiseases.add(withoutQuotes);
				}
				if (faux.getName().equals("MAIN::StuntedStem")) {					
					if(faux.getSlotValue("stuntedStem").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::SmallLeaves")) {					
					if(faux.getSlotValue("smallLeaves").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::BlackStems")) {									
					if(faux.getSlotValue("blackStems").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::VineWilting")) {										
					if(faux.getSlotValue("vineWilting").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::BrittleStems")) {					
					if(faux.getSlotValue("brittleStems").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::BrownLessions")) {					
					if(faux.getSlotValue("brownLessions").equals("yes")){
						count++;
					}						
				}
				
				diagnosis="";
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		DecimalFormat fmt=new DecimalFormat("0.##");
		List<String> percentList=new ArrayList<String>();
		float percent=0;
		//begin: calculate percent
		for(int i=0;i<listOfDiseases.size();i++){
		if((listOfDiseases.get(i)).equals("black leg")){
			percent=(3/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("White Mold")){
			percent=(2/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Late blight")){
			percent=(1/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		}
		//end
		
		Map<String,String> map = new HashMap<String,String>();
		for(int i=0;i<listOfDiseases.size();i++){
			map.put(listOfDiseases.get(i), percentList.get(i));
		}
		mav.addObject("count",count);
		request.setAttribute("maps", map);
		
		//mav.addObject("diseases", listOfDiseases);
		return mav;
	}
	
	@RequestMapping(value = "/potatoTuberDiag", method = RequestMethod.POST)
	public ModelAndView tuberDiagnosis(@Valid PotatoTuberModel ptm,HttpServletRequest request,HttpSession session) {
		ModelAndView mav = new ModelAndView("potatoDiseasesFound");
		
		String logid = "" + session.getAttribute("logid");
		int lid = Integer.parseInt(logid);

		Session sess = factory.openSession();

		String username = "";
		Query qrey = sess.createQuery("from LoginModel c where c.logid=:lid");
		qrey.setInteger("lid", lid);
		List l = qrey.list();
		Iterator itF = l.iterator();
		while (itF.hasNext()) {
			Object o = (Object) itF.next();
			LoginModel log = (LoginModel) o;
			username = log.getUsername();
		}
		int farmerId = 0;
		Query qrey1 = sess.createQuery("from FarmerModel c where c.phonenum=:pnum");
		qrey1.setString("pnum", username);
		List l1 = qrey1.list();
		Iterator it1 = l1.iterator();
		while (it1.hasNext()) {
			Object o = (Object) it1.next();
			FarmerModel fm = (FarmerModel) o;
			farmerId = fm.getFarmerId();
		}
		mav.addObject("farmerId", farmerId);

		rete = new Rete();
		try {
			rete.batch("C:\\xampp\\tomcat\\webapps\\ExpertSystem\\clipsFiles\\potatotuberdiagnosis.clp");
		} catch (JessException ex) {
			Logger.getLogger(PotatoSymptomsController.class.getName()).log(Level.SEVERE, null,
					ex);
		}

		try {
			rete.assertString("(VascularRing (vascularRing "+ ptm.getVascularRing() + "))");
			rete.assertString("(IrregularBrown (irregularBrown " + ptm.getIrregularBrown() + "))");
			rete.assertString("(BrownPatches (brownPatches " + ptm.getBrownPatches() + "))");
			rete.assertString("(IrregularlyShape (irregularlyShape "+ ptm.getIrregularlyShape() + "))");
			rete.assertString("(DiscolouredPatches (discolouredPatches "+ ptm.getDiscolouredPatches() + "))");			
			rete.assertString("(CrackSurface (crackSurface "+ ptm.getCrackSurface() + "))");			
			rete.assertString("(RubberyTuber (rubberyTuber "+ ptm.getRubberyTuber() + "))");
			rete.assertString("(GreySkin (greySkin " + ptm.getGreySkin() + "))");
			rete.assertString("(LeatherySpots (leatherySpots " + ptm.getLeatherySpots() + "))");
			rete.assertString("(SilverySkin (silverySkin "+ ptm.getSilverySkin() + "))");
			rete.assertString("(SootyAppearance (sootyAppearance "+ ptm.getSootyAppearance() + "))");			
			rete.assertString("(PurplishPimples (purplishPimples "+ ptm.getPurplishPimples() + "))");			
			rete.assertString("(RaisedSpots (raisedSpots " + ptm.getRaisedSpots() + "))");
			rete.assertString("(DarkArcs (darkArcs "+ ptm.getDarkArcs() + "))");
			rete.assertString("(CrackedTubers (crackedTubers "+ ptm.getCrackedTubers() + "))");			
			rete.assertString("(DiscolouredTuber (discolouredTuber "+ ptm.getDiscolouredTuber() + "))");
			
		} catch (JessException ex) {
			Logger.getLogger(PotatoSymptomsController.class.getName()).log(
					Level.SEVERE, null, ex);
		}
		try {
			rete.executeCommand("(facts)");
		} catch (JessException ex) {
			Logger.getLogger(PotatoSymptomsController.class.getName()).log(
					Level.SEVERE, null, ex);
		}

		List<String> listOfDiseases=new ArrayList<String>();
		float count=0;
		String diagnosis = "";
		try {
			rete.run();
			Iterator it = rete.listFacts();
			Fact faux;

			while (it.hasNext()) {
				faux = (Fact) it.next();
				if (faux.getName().equals("MAIN::Diagnosis")) {
					diagnosis += faux.getSlotValue("diagnosis");
					String withoutQuotes=diagnosis.replace("\"", "");
					listOfDiseases.add(withoutQuotes);
				}
				if (faux.getName().equals("MAIN::VascularRing")) {					
					if(faux.getSlotValue("vascularRing").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::IrregularBrown")) {					
					if(faux.getSlotValue("irregularBrown").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::BrownPatches")) {									
					if(faux.getSlotValue("brownPatches").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::IrregularlyShape")) {										
					if(faux.getSlotValue("irregularlyShape").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::DiscolouredPatches")) {					
					if(faux.getSlotValue("discolouredPatches").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::CrackSurface")) {					
					if(faux.getSlotValue("crackSurface").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::RubberyTuber")) {									
					if(faux.getSlotValue("rubberyTuber").equals("yes")){
						count++;
					}						
				}
				///
				if (faux.getName().equals("MAIN::GreySkin")) {					
					if(faux.getSlotValue("greySkin").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::LeatherySpots")) {					
					if(faux.getSlotValue("leatherySpots").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::SilverySkin")) {									
					if(faux.getSlotValue("silverySkin").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::SootyAppearance")) {										
					if(faux.getSlotValue("sootyAppearance").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::PurplishPimples")) {					
					if(faux.getSlotValue("purplishPimples").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::RaisedSpots")) {					
					if(faux.getSlotValue("raisedSpots").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::DarkArcs")) {									
					if(faux.getSlotValue("darkArcs").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::CrackedTubers")) {					
					if(faux.getSlotValue("crackedTubers").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::DiscolouredTuber")) {									
					if(faux.getSlotValue("discolouredTuber").equals("yes")){
						count++;
					}						
				}
				diagnosis="";
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		DecimalFormat fmt=new DecimalFormat("0.##");
		List<String> percentList=new ArrayList<String>();
		float percent=0;
		//begin: calculate percent
		for(int i=0;i<listOfDiseases.size();i++){
		if((listOfDiseases.get(i)).equals("brown rot")){
			percent=(1/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("potato scabs")){
			percent=(1/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Dry rot")){
			percent=(1/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Gangrene")){
			percent=(1/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Pink rot")){
			percent=(1/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Bacterial Ring Rot")){
			percent=(1/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Rubbery rot")){
			percent=(2/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Silver Scurf")){
			percent=(3/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Skin Spot")){
			percent=(2/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Potato moptop virus")){
			percent=(2/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Watery Wound Rot")){
			percent=(1/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		}
		//end
		
		Map<String,String> map = new HashMap<String,String>();
		for(int i=0;i<listOfDiseases.size();i++){
			map.put(listOfDiseases.get(i), percentList.get(i));
		}
		mav.addObject("count",count);
		request.setAttribute("maps", map);
		
		//mav.addObject("diseases", listOfDiseases);
		return mav;
	}
	@RequestMapping(value = "/potatoWholePlantDiag", method = RequestMethod.POST)
	public ModelAndView wholePlantDiagnosis(@Valid PotatoWholePlantModel pwm,HttpServletRequest request,HttpSession session) {
		ModelAndView mav = new ModelAndView("potatoDiseasesFound");
		
		String logid = "" + session.getAttribute("logid");
		int lid = Integer.parseInt(logid);

		Session sess = factory.openSession();

		String username = "";
		Query qrey = sess.createQuery("from LoginModel c where c.logid=:lid");
		qrey.setInteger("lid", lid);
		List l = qrey.list();
		Iterator itF = l.iterator();
		while (itF.hasNext()) {
			Object o = (Object) itF.next();
			LoginModel log = (LoginModel) o;
			username = log.getUsername();
		}
		int farmerId = 0;
		Query qrey1 = sess.createQuery("from FarmerModel c where c.phonenum=:pnum");
		qrey1.setString("pnum", username);
		List l1 = qrey1.list();
		Iterator it1 = l1.iterator();
		while (it1.hasNext()) {
			Object o = (Object) it1.next();
			FarmerModel fm = (FarmerModel) o;
			farmerId = fm.getFarmerId();
		}
		mav.addObject("farmerId", farmerId);

		rete = new Rete();
		try {
			rete.batch("C:\\xampp\\tomcat\\webapps\\ExpertSystem\\clipsFiles\\potatowholeplantdiagnosis.clp");
		} catch (JessException ex) {
			Logger.getLogger(PotatoSymptomsController.class.getName()).log(Level.SEVERE, null,
					ex);
		}

		try {
			rete.assertString("(DarkLessions (darkLessions "+ pwm.getDarkLessions() + "))");
			rete.assertString("(RoundLeafspot (roundLeafspot " + pwm.getRoundLeafspot() + "))");
			rete.assertString("(YellowLeaves (yellowLeaves " + pwm.getYellowLeaves() + "))");
			rete.assertString("(DarkTubers (darkTubers "+ pwm.getDarkTubers() + "))");
			rete.assertString("(CorkyTissue (corkyTissue "+ pwm.getCorkyTissue() + "))");			
			rete.assertString("(ShrivelledLeaves (shrivelledLeaves "+ pwm.getShrivelledLeaves() + "))");			
			rete.assertString("(IrregularOlive (irregularOlive "+ pwm.getIrregularOlive() + "))");
			rete.assertString("(PowderyFungalgrowth (powderyFungalgrowth " + pwm.getPowderyFungalgrowth() + "))");
			rete.assertString("(PurpleLesions (purpleLesions " + pwm.getPurpleLesions() + "))");
			rete.assertString("(ReddishDryrot (reddishDryrot "+ pwm.getReddishDryrot() + "))");
			rete.assertString("(ElongatedLesions (elongatedLesions "+ pwm.getElongatedLesions() + "))");			
			rete.assertString("(LeavesWilt (leavesWilt "+ pwm.getLeavesWilt() + "))");			
			rete.assertString("(FluffyFungalgrowth (fluffyFungalgrowth " + pwm.getFluffyFungalgrowth() + "))");
			rete.assertString("(IrregularPatches (irregularPatches "+ pwm.getIrregularPatches() + "))");
			rete.assertString("(BlackDots (blackDots "+ pwm.getBlackDots() + "))");			
			rete.assertString("(SlimyLesions (slimyLesions "+ pwm.getSlimyLesions() + "))");
			rete.assertString("(StuntedPlant (stuntedPlant " + pwm.getStuntedPlant() + "))");
			rete.assertString("(GrayFlakygrowth (grayFlakygrowth "+ pwm.getGrayFlakygrowth() + "))");
			rete.assertString("(BrownDryspots (brownDryspots "+ pwm.getBrownDryspots() + "))");			
			rete.assertString("(HardBlackspots (hardBlackspots "+ pwm.getHardBlackspots() + "))");			
			rete.assertString("(DeformedTubers (deformedTubers " + pwm.getDeformedTubers() + "))");
			rete.assertString("(GreenTubers (greenTubers "+ pwm.getGreenTubers() + "))");
			rete.assertString("(MottledStems (mottledStems "+ pwm.getMottledStems() + "))");			
			rete.assertString("(YellowRings (yellowRings "+ pwm.getYellowRings() + "))");
			rete.assertString("(BrownRings (brownRings "+ pwm.getBrownRings() + "))");			
			rete.assertString("(CrackedTubers (crackedTubers "+ pwm.getCrackedTubers() + "))");
			
			
		} catch (JessException ex) {
			Logger.getLogger(PotatoSymptomsController.class.getName()).log(
					Level.SEVERE, null, ex);
		}
		try {
			rete.executeCommand("(facts)");
		} catch (JessException ex) {
			Logger.getLogger(PotatoSymptomsController.class.getName()).log(
					Level.SEVERE, null, ex);
		}

		List<String> listOfDiseases=new ArrayList<String>();
		float count=0;
		String diagnosis = "";
		try {
			rete.run();
			Iterator it = rete.listFacts();
			Fact faux;

			while (it.hasNext()) {
				faux = (Fact) it.next();
				if (faux.getName().equals("MAIN::Diagnosis")) {
					diagnosis += faux.getSlotValue("diagnosis");
					String withoutQuotes=diagnosis.replace("\"", "");
					listOfDiseases.add(withoutQuotes);
				}
				if (faux.getName().equals("MAIN::DarkLessions")) {					
					if(faux.getSlotValue("darkLessions").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::RoundLeafspot")) {					
					if(faux.getSlotValue("roundLeafspot").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::YellowLeaves")) {									
					if(faux.getSlotValue("yellowLeaves").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::DarkTubers")) {										
					if(faux.getSlotValue("darkTubers").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::CorkyTissue")) {					
					if(faux.getSlotValue("corkyTissue").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::ShrivelledLeaves")) {					
					if(faux.getSlotValue("shrivelledLeaves").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::IrregularOlive")) {									
					if(faux.getSlotValue("irregularOlive").equals("yes")){
						count++;
					}						
				}
				///
				if (faux.getName().equals("MAIN::PowderyFungalgrowth")) {					
					if(faux.getSlotValue("powderyFungalgrowth").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::PurpleLesions")) {					
					if(faux.getSlotValue("purpleLesions").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::ReddishDryrot")) {									
					if(faux.getSlotValue("reddishDryrot").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::ElongatedLesions")) {										
					if(faux.getSlotValue("elongatedLesions").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::LeavesWilt")) {					
					if(faux.getSlotValue("leavesWilt").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::FluffyFungalgrowth")) {					
					if(faux.getSlotValue("fluffyFungalgrowth").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::IrregularPatches")) {									
					if(faux.getSlotValue("irregularPatches").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::BlackDots")) {					
					if(faux.getSlotValue("blackDots").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::SlimyLesions")) {									
					if(faux.getSlotValue("slimyLesions").equals("yes")){
						count++;
					}						
				}
				////
				if (faux.getName().equals("MAIN::StuntedPlant")) {									
					if(faux.getSlotValue("stuntedPlant").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::GrayFlakygrowth")) {										
					if(faux.getSlotValue("grayFlakygrowth").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::BrownDryspots")) {					
					if(faux.getSlotValue("brownDryspots").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::HardBlackspots")) {					
					if(faux.getSlotValue("hardBlackspots").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::DeformedTubers")) {									
					if(faux.getSlotValue("deformedTubers").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::GreenTubers")) {					
					if(faux.getSlotValue("greenTubers").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::MottledStems")) {									
					if(faux.getSlotValue("mottledStems").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::YellowRings")) {									
					if(faux.getSlotValue("yellowRings").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::BrownRings")) {					
					if(faux.getSlotValue("brownRings").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::CrackedTubers")) {									
					if(faux.getSlotValue("crackedTubers").equals("yes")){
						count++;
					}						
				}
				diagnosis="";
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		DecimalFormat fmt=new DecimalFormat("0.##");
		List<String> percentList=new ArrayList<String>();
		float percent=0;
		//begin: calculate percent
		for(int i=0;i<listOfDiseases.size();i++){
		if((listOfDiseases.get(i)).equals("Early Blight")){
			percent=(5/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Late Blight")){
			percent=(5/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("White Mold")){
			percent=(3/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Black Dot")){
			percent=(4/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Blackleg")){
			percent=(3/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Black Scurf")){
			percent=(5/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Corky Ring Spot")){
			percent=(4/count)*100;
			percentList.add(""+fmt.format(percent));
		}		
		}
		//end
		
		Map<String,String> map = new HashMap<String,String>();
		for(int i=0;i<listOfDiseases.size();i++){
			map.put(listOfDiseases.get(i), percentList.get(i));
		}
		mav.addObject("count",count);
		request.setAttribute("maps", map);
		
		//mav.addObject("diseases", listOfDiseases);
		return mav;
	}
}
