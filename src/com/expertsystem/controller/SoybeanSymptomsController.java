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
public class SoybeanSymptomsController {

	private static Rete rete;
	
	@Autowired
	SessionFactory factory;
	
	@RequestMapping(value = "/soybeanpartsaffected", method = RequestMethod.GET)
	public ModelAndView partsAffected(HttpSession session) {
		ModelAndView mav = new ModelAndView("soybeanPartsAffected");
		
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
	@RequestMapping(value = "/soybeanDiagnosisResult", method = RequestMethod.GET)
	public ModelAndView diagnosisResult(@RequestParam("listValue")String listValue,HttpServletRequest request,HttpSession session) {
		ModelAndView mav = new ModelAndView("diagnosisResult");		

		//SessionFactory factory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session sess = factory.openSession();

		Query query = sess.createQuery("from SoybeanDiseaseModel r where r.diseaseName=:diag");
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

	@RequestMapping(value = "/soybeanfoliar", method = RequestMethod.GET)
	public ModelAndView foliarSymptom(HttpSession session) {
		ModelAndView mav = new ModelAndView("soybeanFoliarSymtoms");
		
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
		
		SoybeanFoliarModel foliar = new SoybeanFoliarModel();
		mav.getModelMap().put("soybeanFoliarSymtoms", foliar);
		return mav;
	}

	@RequestMapping(value = "/soybeanroot", method = RequestMethod.GET)
	public ModelAndView rootSymptom(HttpSession session) {
		ModelAndView mav = new ModelAndView("soybeanRootStemSymptoms");
		
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
		
		SoybeanRootModel root = new SoybeanRootModel();
		mav.getModelMap().put("soybeanRootStemSymptoms", root);
		return mav;
	}

	@RequestMapping(value = "/soybeanseed", method = RequestMethod.GET)
	public ModelAndView seedSymptom(HttpSession session) {
		ModelAndView mav = new ModelAndView("soybeanSeedSymptoms");
		
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
		
		SoybeanSeedModel seed = new SoybeanSeedModel();
		mav.getModelMap().put("soybeanSeedSymptoms", seed);
		return mav;
	}


	@RequestMapping(value = "/soybeanFoliarDiag", method = RequestMethod.POST)
	public ModelAndView foliarDiagnosis(@Valid SoybeanFoliarModel sfm,HttpServletRequest request,HttpSession session) {
		ModelAndView mav = new ModelAndView("soybeanDiseasesFound");
		
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
			rete.batch("C:\\xampp\\tomcat\\webapps\\ExpertSystem\\clipsFiles\\soybeanfoliardiagnosis.clp");
		} catch (JessException ex) {
			Logger.getLogger(SoybeanSymptomsController.class.getName()).log(Level.SEVERE, null,
					ex);
		}

		try {
			rete.assertString("(LessionLeaves (lessionLeaves "+ sfm.getLessionLeaves() + "))");
			rete.assertString("(SmallPots (smallPots " + sfm.getSmallPots() + "))");
			rete.assertString("(MottlingLeaves (mottlingLeaves " + sfm.getMottlingLeaves() + "))");
			rete.assertString("(StutedPlants (stutedPlants "+ sfm.getStutedPlants() + "))");
			rete.assertString("(TerminalBud (terminalBud "+ sfm.getTerminalBud() + "))");		
			rete.assertString("(SmallerLeaflets (smallerLeaflets "+ sfm.getSmallerLeaflets() + "))");
			rete.assertString("(BrownPatches (brownPatches " + sfm.getBrownPatches() + "))");
			rete.assertString("(SunburnedLeaves (sunburnedLeaves " + sfm.getSunburnedLeaves() + "))");
			rete.assertString("(RedbrownSpots (redbrownSpots "+ sfm.getRedbrownSpots() + "))");
			rete.assertString("(GreenSpots (greenSpots "+ sfm.getGreenSpots() + "))");			
			rete.assertString("(IrregularSpots (irregularSpots "+ sfm.getIrregularSpots() + "))");
			rete.assertString("(LeavesWilting (leavesWilting " + sfm.getLeavesWilting() + "))");
			rete.assertString("(LeavesScorching (leavesScorching " + sfm.getLeavesScorching() + "))");
			rete.assertString("(RustyPatches (rustyPatches "+ sfm.getRustyPatches() + "))");			
			rete.assertString("(DarkBrownSpots (darkBrownSpots " + sfm.getDarkBrownSpots() + "))");
			rete.assertString("(LeavesDrop (leavesDrop " + sfm.getLeavesDrop() + "))");
			rete.assertString("(PuckeredLeaf (puckeredLeaf "+ sfm.getPuckeredLeaf() + "))");
			
		} catch (JessException ex) {
			Logger.getLogger(SoybeanSymptomsController.class.getName()).log(
					Level.SEVERE, null, ex);
		}
		try {
			rete.executeCommand("(facts)");
		} catch (JessException ex) {
			Logger.getLogger(SoybeanSymptomsController.class.getName()).log(
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
				if (faux.getName().equals("MAIN::LessionLeaves")) {					
					if(faux.getSlotValue("lessionLeaves").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::SmallPots")) {					
					if(faux.getSlotValue("smallPots").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::MottlingLeaves")) {									
					if(faux.getSlotValue("mottlingLeaves").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::StutedPlants")) {										
					if(faux.getSlotValue("stutedPlants").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::TerminalBud")) {					
					if(faux.getSlotValue("terminalBud").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::SmallerLeaflets")) {					
					if(faux.getSlotValue("smallerLeaflets").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::BrownPatches")) {									
					if(faux.getSlotValue("brownPatches").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::SunburnedLeaves")) {					
					if(faux.getSlotValue("sunburnedLeaves").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::RedbrownSpots")) {									
					if(faux.getSlotValue("redbrownSpots").equals("yes")){
						count++;
					}						
				}
				///
				if (faux.getName().equals("MAIN::GreenSpots")) {					
					if(faux.getSlotValue("greenSpots").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::IrregularSpots")) {					
					if(faux.getSlotValue("irregularSpots").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::LeavesWilting")) {									
					if(faux.getSlotValue("leavesWilting").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::LeavesScorching")) {										
					if(faux.getSlotValue("leavesScorching").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::RustyPatches")) {					
					if(faux.getSlotValue("rustyPatches").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::DarkBrownSpots")) {					
					if(faux.getSlotValue("darkBrownSpots").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::LeavesDrop")) {									
					if(faux.getSlotValue("leavesDrop").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::PuckeredLeaf")) {					
					if(faux.getSlotValue("puckeredLeaf").equals("yes")){
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
		if((listOfDiseases.get(i)).equals("Bacterial Blight")){
			percent=(2/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Bean Pod Mottle")){
			percent=(1/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Bud Blight")){
			percent=(4/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Cercospora Leaf Blight")){
			percent=(2/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Downy Mildew")){
			percent=(1/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Frogeye Leaf Spot")){
			percent=(2/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Powdery Mildew")){
			percent=(2/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Septoria Brown Spot")){
			percent=(2/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Soybean Mosaic")){
			percent=(3/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Soybean Rust")){
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
	
	@RequestMapping(value = "/soybeanRootDiag", method = RequestMethod.POST)
	public ModelAndView rootDiagnosis(@Valid SoybeanRootModel srm,HttpServletRequest request,HttpSession session) {
		ModelAndView mav = new ModelAndView("soybeanDiseasesFound");
		
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
			rete.batch("C:\\xampp\\tomcat\\webapps\\ExpertSystem\\clipsFiles\\soybeanrootdiagnosis.clp");
		} catch (JessException ex) {
			Logger.getLogger(SoybeanSymptomsController.class.getName()).log(Level.SEVERE, null,
					ex);
		}

		try {
			rete.assertString("(VascularSystem (vascularSystem "+ srm.getVascularSystem() + "))");
			rete.assertString("(GrayTaproot (grayTaproot " + srm.getGrayTaproot() + "))");
			rete.assertString("(Epidermis (epidermis " + srm.getEpidermis() + "))");
			rete.assertString("(BruisedStems (bruisedStems "+ srm.getBruisedStems() + "))");
			rete.assertString("(RootLesions (rootLesions "+ srm.getRootLesions() + "))");		
			rete.assertString("(WiltingLeaves (wiltingLeaves "+ srm.getWiltingLeaves() + "))");
			rete.assertString("(RaisedDots (raisedDots " + srm.getRaisedDots() + "))");
			rete.assertString("(SunburnedLeaves (sunburnedLeaves " + srm.getSunburnedLeaves() + "))");
			rete.assertString("(BlackSclerotia (blackSclerotia "+ srm.getBlackSclerotia() + "))");
			rete.assertString("(BrownDiscoloration (brownDiscoloration "+ srm.getBrownDiscoloration() + "))");			
			rete.assertString("(TinyblackDots (tinyblackDots "+ srm.getTinyblackDots() + "))");
		
		} catch (JessException ex) {
			Logger.getLogger(SoybeanSymptomsController.class.getName()).log(
					Level.SEVERE, null, ex);
		}
		try {
			rete.executeCommand("(facts)");
		} catch (JessException ex) {
			Logger.getLogger(SoybeanSymptomsController.class.getName()).log(
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
				if (faux.getName().equals("MAIN::VascularSystem")) {					
					if(faux.getSlotValue("vascularSystem").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::GrayTaproot")) {					
					if(faux.getSlotValue("grayTaproot").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::Epidermis")) {									
					if(faux.getSlotValue("epidermis").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::BruisedStems")) {										
					if(faux.getSlotValue("bruisedStems").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::RootLesions")) {					
					if(faux.getSlotValue("rootLesions").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::WiltingLeaves")) {					
					if(faux.getSlotValue("wiltingLeaves").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::RaisedDots")) {									
					if(faux.getSlotValue("raisedDots").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::SunburnedLeaves")) {					
					if(faux.getSlotValue("sunburnedLeaves").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::BlackSclerotia")) {									
					if(faux.getSlotValue("blackSclerotia").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::BrownDiscoloration")) {					
					if(faux.getSlotValue("brownDiscoloration").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::TinyblackDots")) {									
					if(faux.getSlotValue("tinyblackDots").equals("yes")){
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
		if((listOfDiseases.get(i)).equals("Brown Stem Rot")){
			percent=(1/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Charcoal Rot")){
			percent=(2/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Phytophthora Rot")){
			percent=(3/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Stem Blight")){
			percent=(1/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Purple Seed Stain")){
			percent=(1/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Sclerotinia Stem Rot")){
			percent=(1/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Stem Canker")){
			percent=(2/count)*100;
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
	
	@RequestMapping(value = "/soybeanSeedDiag", method = RequestMethod.POST)
	public ModelAndView seedDiagnosis(@Valid SoybeanSeedModel ssm,HttpServletRequest request,HttpSession session) {
		ModelAndView mav = new ModelAndView("soybeanDiseasesFound");
		
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
			rete.batch("C:\\xampp\\tomcat\\webapps\\ExpertSystem\\clipsFiles\\soybeanseeddiagnosis.clp");
		} catch (JessException ex) {
			Logger.getLogger(SoybeanSymptomsController.class.getName()).log(Level.SEVERE, null,
					ex);
		}

		try {
			rete.assertString("(DampingOff (dampingOff "+ ssm.getDampingOff() + "))");
			rete.assertString("(BruisedStems (bruisedStems " + ssm.getBruisedStems() + "))");
			rete.assertString("(RottingTissue (rottingTissue " + ssm.getRottingTissue() + "))");
			rete.assertString("(SunkenLesion (sunkenLesion "+ ssm.getSunkenLesion() + "))");
			
		
		} catch (JessException ex) {
			Logger.getLogger(SoybeanSymptomsController.class.getName()).log(
					Level.SEVERE, null, ex);
		}
		try {
			rete.executeCommand("(facts)");
		} catch (JessException ex) {
			Logger.getLogger(SoybeanSymptomsController.class.getName()).log(
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
				if (faux.getName().equals("MAIN::DampingOff")) {					
					if(faux.getSlotValue("dampingOff").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::BruisedStems")) {					
					if(faux.getSlotValue("bruisedStems").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::RottingTissue")) {									
					if(faux.getSlotValue("rottingTissue").equals("yes")){
						count++;
					}						
				}
				if (faux.getName().equals("MAIN::SunkenLesion")) {										
					if(faux.getSlotValue("sunkenLesion").equals("yes")){
						count++;
					}						
				}
				
				diagnosis="";
			}
		}catch (Exception e) {

		}
		DecimalFormat fmt=new DecimalFormat("0.##");
		List<String> percentList=new ArrayList<String>();
		float percent=0;
		//begin: calculate percent
		for(int i=0;i<listOfDiseases.size();i++){
		if((listOfDiseases.get(i)).equals("Seedling Blight")){
			percent=(2/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Pythium Seedling")){
			percent=(2/count)*100;
			percentList.add(""+fmt.format(percent));
		}
		if((listOfDiseases.get(i)).equals("Rhizoctonia Root Rot")){
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
}
