package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project.persistence.entities.User;
import project.persistence.entities.Event;
import project.persistence.entities.Group;
import project.service.GroupService;
import project.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GroupController {

	// Instance Variables
	// StringManipulationService stringService;
	GroupService groupService;
	UserService userService;

	// Dependency Injection
	@Autowired
	public GroupController(GroupService groupService, UserService userService) {
		this.groupService = groupService;
		this.userService = userService;
		
		/*Group annunaki = new Group("Nörd", "Allir meðlimir nörd. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",true);
		Group bubb = new Group("Bubb og co.", "Allir vinir hans bubba. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",true);
		Group brh = new Group("BRH BOYS", "Bara fyrir boys úr Breiðholti. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",true);
		Group golf = new Group("Golf Crew", "ef þú hefur áhuga á golfi.. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", true);
		Group fjolla = new Group("Fjöllan", "Blöndal ættin. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", false);
		Group bolta = new Group("BumbuBolti", "Bolti fyrir fólk með bumbu. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", true);
		Group afm = new Group("Afmæli", "Vinum mínum sem er boðið í afmæli mitt. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", false);
		Group bio = new Group("Bíóklúbburinn", "Bíó alla þriðjudaga, PEPP! Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", true);
		Group laera = new Group("Study-hópur", "Study hópur í hugbúnaðarverkefni 1. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", false);
		
		
		groupService.addGroup(annunaki);
		groupService.addGroup(bubb);
		groupService.addGroup(brh);
		groupService.addGroup(golf);
		groupService.addGroup(fjolla);
		groupService.addGroup(bolta);
		groupService.addGroup(afm);
		groupService.addGroup(bio);
		groupService.addGroup(laera);*/
		
		
		
		//groupService.addMember(userService.findByUsername("adam").get(0), laera.getGroupID());
		//groupService.addMember(userService.findByUsername("birgir").get(0), laera.getGroupID());
		//groupService.addMember(userService.findByUsername("marino").get(0), laera.getGroupID());
		/*groupService.addMember(userService.findByUsername("umballreopen").get(0), annunaki.getGroupID());
		groupService.addMember(userService.findByUsername("bonnykelvin").get(0), annunaki.getGroupID());
		groupService.addMember(userService.findByUsername("journeyblakehope").get(0), annunaki.getGroupID());
		groupService.addMember(userService.findByUsername("alleetyped").get(0), annunaki.getGroupID());
		groupService.addMember(userService.findByUsername("despairingflavoured").get(0), annunaki.getGroupID());
		groupService.addMember(userService.findByUsername("walruspainter").get(0), annunaki.getGroupID());
		groupService.addMember(userService.findByUsername("stunnervegetarian").get(0), annunaki.getGroupID());
		groupService.addMember(userService.findByUsername("broadjockey").get(0), annunaki.getGroupID());
		groupService.addMember(userService.findByUsername("hulaquarterdeck").get(0), annunaki.getGroupID());
		groupService.addMember(userService.findByUsername("codingcozy").get(0), annunaki.getGroupID());
		groupService.addMember(userService.findByUsername("sleautycallaly").get(0), annunaki.getGroupID());
		groupService.addMember(userService.findByUsername("bruiseungodly").get(0), annunaki.getGroupID());
		groupService.addMember(userService.findByUsername("alongsidebeamer").get(0), annunaki.getGroupID());
		groupService.addMember(userService.findByUsername("audiwobble").get(0), annunaki.getGroupID());
		groupService.addMember(userService.findByUsername("contributionbanners").get(0), annunaki.getGroupID());
		groupService.addMember(userService.findByUsername("gutlessharmful").get(0), annunaki.getGroupID());
		groupService.addMember(userService.findByUsername("senatorswin").get(0), annunaki.getGroupID());
		groupService.addMember(userService.findByUsername("avowrouting").get(0), annunaki.getGroupID());
		groupService.addMember(userService.findByUsername("hilloklahoma").get(0), annunaki.getGroupID());
		groupService.addMember(userService.findByUsername("remarkablelittle").get(0), annunaki.getGroupID());
		groupService.addMember(userService.findByUsername("layingspirit").get(0), annunaki.getGroupID());
		groupService.addMember(userService.findByUsername("phantombewitched").get(0), annunaki.getGroupID());
		groupService.addMember(userService.findByUsername("bellacrobat").get(0), annunaki.getGroupID());
		groupService.addMember(userService.findByUsername("signsbriefcase").get(0), annunaki.getGroupID());
		groupService.addMember(userService.findByUsername("hacksawmoonshine").get(0), annunaki.getGroupID());
		groupService.addMember(userService.findByUsername("examshowy").get(0), annunaki.getGroupID());
		groupService.addMember(userService.findByUsername("caviermartin").get(0), annunaki.getGroupID());
		groupService.addMember(userService.findByUsername("nemocolourless").get(0), annunaki.getGroupID());
		groupService.addMember(userService.findByUsername("snorkelcriticize").get(0), annunaki.getGroupID());
		groupService.addMember(userService.findByUsername("pecanexcuse").get(0), bubb.getGroupID());
		groupService.addMember(userService.findByUsername("followingshopper").get(0), bubb.getGroupID());
		groupService.addMember(userService.findByUsername("towermixture").get(0), bubb.getGroupID());
		groupService.addMember(userService.findByUsername("steadypastebin").get(0), bubb.getGroupID());
		groupService.addMember(userService.findByUsername("sedatenon").get(0), bubb.getGroupID());
		groupService.addMember(userService.findByUsername("snowinesseye").get(0), bubb.getGroupID());
		groupService.addMember(userService.findByUsername("normanjoyous").get(0), bubb.getGroupID());
		groupService.addMember(userService.findByUsername("gustynorma").get(0), bubb.getGroupID());
		groupService.addMember(userService.findByUsername("moristonsignpost").get(0), bubb.getGroupID());
		groupService.addMember(userService.findByUsername("devonposh").get(0), bubb.getGroupID());
		groupService.addMember(userService.findByUsername("hedgingproxy").get(0), bubb.getGroupID());
		groupService.addMember(userService.findByUsername("maeparents").get(0), bubb.getGroupID());
		groupService.addMember(userService.findByUsername("crepespew").get(0), bubb.getGroupID());
		groupService.addMember(userService.findByUsername("finartforsa").get(0), bubb.getGroupID());
		groupService.addMember(userService.findByUsername("countapproval").get(0), bubb.getGroupID());
		groupService.addMember(userService.findByUsername("bungfang").get(0), bubb.getGroupID());
		groupService.addMember(userService.findByUsername("genuinereputably").get(0), bubb.getGroupID());
		groupService.addMember(userService.findByUsername("origintaxonomy").get(0), bubb.getGroupID());
		groupService.addMember(userService.findByUsername("jerryprodigal").get(0), bubb.getGroupID());
		groupService.addMember(userService.findByUsername("sugarsophronia").get(0), bubb.getGroupID());
		groupService.addMember(userService.findByUsername("ziplipstick").get(0), bubb.getGroupID());
		groupService.addMember(userService.findByUsername("battalionbanker").get(0), bubb.getGroupID());
		groupService.addMember(userService.findByUsername("argybargyrecycling").get(0), bubb.getGroupID());
		groupService.addMember(userService.findByUsername("appreciatedeficient").get(0), bubb.getGroupID());
		groupService.addMember(userService.findByUsername("arrowheadshumping").get(0), bubb.getGroupID());
		groupService.addMember(userService.findByUsername("planeapproval").get(0), bubb.getGroupID());
		groupService.addMember(userService.findByUsername("wortyplaytime").get(0), bubb.getGroupID());
		groupService.addMember(userService.findByUsername("guideaward").get(0), bubb.getGroupID());
		groupService.addMember(userService.findByUsername("groovingcows").get(0), bubb.getGroupID());
		groupService.addMember(userService.findByUsername("expanddribbling").get(0), bubb.getGroupID());
		groupService.addMember(userService.findByUsername("husheddisregard").get(0), brh.getGroupID());
		groupService.addMember(userService.findByUsername("stingrayjag").get(0), brh.getGroupID());
		groupService.addMember(userService.findByUsername("cozinessmateo").get(0), brh.getGroupID());
		groupService.addMember(userService.findByUsername("scramblerepona").get(0), brh.getGroupID());
		groupService.addMember(userService.findByUsername("belleratio").get(0), brh.getGroupID());
		groupService.addMember(userService.findByUsername("sinkantler").get(0), brh.getGroupID());
		groupService.addMember(userService.findByUsername("specimendomestic").get(0), brh.getGroupID());
		groupService.addMember(userService.findByUsername("brushwandought").get(0), brh.getGroupID());
		groupService.addMember(userService.findByUsername("outspokenplane").get(0), brh.getGroupID());
		groupService.addMember(userService.findByUsername("jokinglysample").get(0), brh.getGroupID());
		groupService.addMember(userService.findByUsername("gidgetthurso").get(0), brh.getGroupID());
		groupService.addMember(userService.findByUsername("payphonetony").get(0), brh.getGroupID());
		groupService.addMember(userService.findByUsername("quartilestinchar").get(0), brh.getGroupID());
		groupService.addMember(userService.findByUsername("gogglesshove").get(0), brh.getGroupID());
		groupService.addMember(userService.findByUsername("dumplongfellow").get(0), brh.getGroupID());
		groupService.addMember(userService.findByUsername("cohesivefraser").get(0), brh.getGroupID());
		groupService.addMember(userService.findByUsername("fieldramb").get(0), brh.getGroupID());
		groupService.addMember(userService.findByUsername("futureanalysis").get(0), brh.getGroupID());
		groupService.addMember(userService.findByUsername("ceilgrasp").get(0), brh.getGroupID());
		groupService.addMember(userService.findByUsername("rackmeasle").get(0), brh.getGroupID());
		groupService.addMember(userService.findByUsername("kivafuneral").get(0), brh.getGroupID());
		groupService.addMember(userService.findByUsername("objectivekenzi").get(0), brh.getGroupID());
		groupService.addMember(userService.findByUsername("silversialoquent").get(0), brh.getGroupID());
		groupService.addMember(userService.findByUsername("deanfiscally").get(0), brh.getGroupID());
		groupService.addMember(userService.findByUsername("priedrecast").get(0), brh.getGroupID());
		groupService.addMember(userService.findByUsername("joggingjackson").get(0), brh.getGroupID());
		groupService.addMember(userService.findByUsername("supperengine").get(0), brh.getGroupID());
		groupService.addMember(userService.findByUsername("richnessdominique").get(0), brh.getGroupID());
		groupService.addMember(userService.findByUsername("retainingcoaching").get(0), brh.getGroupID());
		groupService.addMember(userService.findByUsername("conditionpeach").get(0), brh.getGroupID());
		groupService.addMember(userService.findByUsername("thesistherapist").get(0), golf.getGroupID());
		groupService.addMember(userService.findByUsername("sdraughtdelirium").get(0), golf.getGroupID());
		groupService.addMember(userService.findByUsername("thoroughsqueak").get(0), golf.getGroupID());
		groupService.addMember(userService.findByUsername("treadmillsample").get(0), golf.getGroupID());
		groupService.addMember(userService.findByUsername("delicacyshadily").get(0), golf.getGroupID());
		groupService.addMember(userService.findByUsername("trolleybusserjeant").get(0), golf.getGroupID());
		groupService.addMember(userService.findByUsername("ridersport").get(0), golf.getGroupID());
		groupService.addMember(userService.findByUsername("attemptomissible").get(0), golf.getGroupID());
		groupService.addMember(userService.findByUsername("slabsimmonds").get(0), golf.getGroupID());
		groupService.addMember(userService.findByUsername("foggyimproving").get(0), golf.getGroupID());
		groupService.addMember(userService.findByUsername("holystonestylus").get(0), golf.getGroupID());
		groupService.addMember(userService.findByUsername("busdating").get(0), golf.getGroupID());
		groupService.addMember(userService.findByUsername("whinesethimble").get(0), golf.getGroupID());
		groupService.addMember(userService.findByUsername("clyindividual").get(0), golf.getGroupID());
		groupService.addMember(userService.findByUsername("volleyamazingly").get(0), golf.getGroupID());
		groupService.addMember(userService.findByUsername("ogmoreambush").get(0), golf.getGroupID());
		groupService.addMember(userService.findByUsername("knitseverity").get(0), golf.getGroupID());
		groupService.addMember(userService.findByUsername("gurukrypton").get(0), golf.getGroupID());
		groupService.addMember(userService.findByUsername("revelationunreeve").get(0), golf.getGroupID());
		groupService.addMember(userService.findByUsername("antimonygem").get(0), golf.getGroupID());
		groupService.addMember(userService.findByUsername("duchessquickest").get(0), golf.getGroupID());
		groupService.addMember(userService.findByUsername("linkedlifting").get(0), golf.getGroupID());
		groupService.addMember(userService.findByUsername("flapreward").get(0), golf.getGroupID());
		groupService.addMember(userService.findByUsername("crakepacked").get(0), golf.getGroupID());
		groupService.addMember(userService.findByUsername("pipetzoologist").get(0), golf.getGroupID());
		groupService.addMember(userService.findByUsername("halfeasel").get(0), golf.getGroupID());
		groupService.addMember(userService.findByUsername("ulcersangellist").get(0), golf.getGroupID());
		groupService.addMember(userService.findByUsername("sunburnvehicle").get(0), golf.getGroupID());
		groupService.addMember(userService.findByUsername("delicatechisholm").get(0), golf.getGroupID());
		groupService.addMember(userService.findByUsername("buttercreamchoice").get(0), golf.getGroupID());
		groupService.addMember(userService.findByUsername("signorrocket").get(0), fjolla.getGroupID());
		groupService.addMember(userService.findByUsername("tauntshivering").get(0), fjolla.getGroupID());
		groupService.addMember(userService.findByUsername("venusfoal").get(0), fjolla.getGroupID());
		groupService.addMember(userService.findByUsername("cambridgelavender").get(0), fjolla.getGroupID());
		groupService.addMember(userService.findByUsername("deletionbearnaise").get(0), fjolla.getGroupID());
		groupService.addMember(userService.findByUsername("chillmatter").get(0), fjolla.getGroupID());
		groupService.addMember(userService.findByUsername("completestalwart").get(0), fjolla.getGroupID());
		groupService.addMember(userService.findByUsername("untoldcost").get(0), fjolla.getGroupID());
		groupService.addMember(userService.findByUsername("sheriffdozed").get(0), fjolla.getGroupID());
		groupService.addMember(userService.findByUsername("slorwardbuzz").get(0), fjolla.getGroupID());
		groupService.addMember(userService.findByUsername("sierrainclude").get(0), bolta.getGroupID());
		groupService.addMember(userService.findByUsername("baffleslap").get(0), bolta.getGroupID());
		groupService.addMember(userService.findByUsername("supermanstaff").get(0), bolta.getGroupID());
		groupService.addMember(userService.findByUsername("shawdonedge").get(0), bolta.getGroupID());
		groupService.addMember(userService.findByUsername("eridanusgloater").get(0), bolta.getGroupID());
		groupService.addMember(userService.findByUsername("utahbrooklyn ").get(0), bolta.getGroupID());
		groupService.addMember(userService.findByUsername("bramleylola").get(0), bolta.getGroupID());
		groupService.addMember(userService.findByUsername("savedcoat").get(0), bolta.getGroupID());
		groupService.addMember(userService.findByUsername("trooppassed").get(0), bolta.getGroupID());
		groupService.addMember(userService.findByUsername("prefercurtsy").get(0), bolta.getGroupID());
		groupService.addMember(userService.findByUsername("stirsnushy").get(0), bolta.getGroupID());
		groupService.addMember(userService.findByUsername("snazzyhushroom").get(0), bolta.getGroupID());
		groupService.addMember(userService.findByUsername("graphguide").get(0), bolta.getGroupID());
		groupService.addMember(userService.findByUsername("eachpeated").get(0), bolta.getGroupID());
		groupService.addMember(userService.findByUsername("headfirstroulette").get(0), bolta.getGroupID());
		groupService.addMember(userService.findByUsername("congenialcello").get(0), bolta.getGroupID());
		groupService.addMember(userService.findByUsername("swooshlethargic").get(0), bolta.getGroupID());
		groupService.addMember(userService.findByUsername("excavatorshank").get(0), bolta.getGroupID());
		groupService.addMember(userService.findByUsername("disarmmost").get(0), bolta.getGroupID());
		groupService.addMember(userService.findByUsername("winnersenator").get(0), bolta.getGroupID());
		groupService.addMember(userService.findByUsername("wingrearview").get(0), bolta.getGroupID());
		groupService.addMember(userService.findByUsername("wombatgarage").get(0), bolta.getGroupID());
		groupService.addMember(userService.findByUsername("cageygolf").get(0), bolta.getGroupID());
		groupService.addMember(userService.findByUsername("snizortopengl").get(0), bolta.getGroupID());
		groupService.addMember(userService.findByUsername("nylonsurd").get(0), bolta.getGroupID());
		groupService.addMember(userService.findByUsername("turnipscratch").get(0), bolta.getGroupID());
		groupService.addMember(userService.findByUsername("blatancymarkham").get(0), bolta.getGroupID());
		groupService.addMember(userService.findByUsername("diligentshindig").get(0), bolta.getGroupID());
		groupService.addMember(userService.findByUsername("ascensionsquire").get(0), bolta.getGroupID());
		groupService.addMember(userService.findByUsername("foundergit").get(0), bolta.getGroupID());
		groupService.addMember(userService.findByUsername("outriggerplural").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("alkalinesuck").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("scoutafrican").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("unchinbrennand").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("couldcanning").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("footagecavernous").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("knutterbased").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("apricotsdressage").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("weeniereliably").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("ankarabarr").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("paellaorchy").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("batmancrewmember").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("directerased").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("fruitfinance").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("deceitskimpily").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("learnedspur").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("yendisappointed").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("disasterdrinking").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("zombieyear").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("coupallearing").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("scroorsprawl").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("scopeodiferous").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("smallweedrights").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("shannonprotest").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("sphericalperfume").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("locksfeedback").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("siftcollide").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("finchfreedom").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("maddancing").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("numbingandromeda").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("shotcountless").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("reformistsky").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("maskedroman").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("haltingdream").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("jaggedslushy").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("baziloutmatch").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("synergytrapping").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("crisparklekindle").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("overlyingbeatrice").get(0), bio.getGroupID());
		groupService.addMember(userService.findByUsername("kittybagpipe").get(0), bio.getGroupID());*/
		
		
	}

	// To call this method, enter "localhost:8080/user" into a browser
	@RequestMapping(value = "/Group", method = RequestMethod.GET)
	public String user(Model model) {
		return "Group";
	}

	@RequestMapping(value = "/createGroup", method = RequestMethod.GET)
	public String createEvent(Model model) {

		return "createGroup";
	}

	@RequestMapping(value = "/addGroup", method = RequestMethod.POST)
	public String groupViewGroup(@ModelAttribute("groups") Group groups, Model model,
			@RequestParam("groupInfo") String groupInfo, @RequestParam("groupName") String groupName,@RequestParam("groupVisable") String visable) {

		// Save the Postit Note that we received from the form
		
		User user = userService.getCurrentUser();
		System.out.println(visable);
		Boolean vis = false;
		
		System.out.println(visable + "----------------------");

		if(visable.contains("private")) {
			vis = false;
		}
		else if(visable.contains("public") )  {
			vis = true;
		}
		Group newGroup = new Group(groupName, groupInfo,vis);
		
		System.out.println(newGroup.getGroupName() + " --- " + newGroup.getGroupInfo());
		groupService.addGroup(newGroup);
		System.out.println("Group added===============================================");
		groupService.addMember(user, newGroup.getGroupID());
		// Here we get all the Postit Notes (in a reverse order) and add them to the
		// model
		

		// Add a new Postit Note to the model for the form
		// If you look at the form in PostitNotes.jsp, you can see that we
		// reference this attribute there by the name `postitNote`.
		model.addAttribute("groups", newGroup);

		System.out.println("virkar===============================================");
		// Return the view
		return showAll(model);
	}

	@RequestMapping(value = "/findGroups", method = RequestMethod.POST)
	public String SearchUser(@ModelAttribute("groups") Group group, Model model,
			@RequestParam("groupName") String groupName) {

		System.out.println("calling service function================================");
		List<Group> search = groupService.findByName(groupName);
		User user = userService.getCurrentUser();
		
		List<Group> show = new ArrayList<Group>();
		
		for(Group g : search) {
			if(g.getVisable() || g.getMembers().contains(user.getEmail())) {
				show.add(g);
			}
		}

		model.addAttribute("groupsList", show);
		// model.addAttribute("user", temp );

		System.out.println("done looking ================================");

		return "Group";
	}

	@RequestMapping(value = "/group/{id}", method = RequestMethod.GET)
	public String goToViewGroup(@PathVariable Long id, Model model) {

		List<Group> groupview = new ArrayList();
		
		Group view = groupService.findGroupByID(id);
		groupview.add(view);

		model.addAttribute("currentGroup", groupview);
		
		groupService.setCurrentGroup(view);
		
		ArrayList<String> memberEmails = view.getMembers();
		ArrayList<User> members = new ArrayList<User>();
		
		for(String em : memberEmails) {
			User u = userService.findByEmail(em);
			members.add(u);
			System.out.println(u.getEmail());
		}
		
		model.addAttribute("membersOfgroup", members );

		// Get all Postit Notes with this name and add them to the model
		// model.addAttribute("postitNotes", postitNoteService.findByName(name));

		// Add a new Postit Note to the model for the form
		// If you look at the form in PostitNotes.jsp, you can see that we
		// reference this attribute there by the name `postitNote`.
		// model.addAttribute("postitNote", new PostitNote());

		// Return the view
		return "ViewGroup";
	}

	@RequestMapping(value = "/showAllGroups", method = RequestMethod.GET)
	public String showAll(Model model) {

		System.out.println("SHOW ALL");
		List<Group> search = groupService.findAllGroups();
		
		User user = userService.getCurrentUser();
		
		List<Group> show = new ArrayList<Group>();
		
		for(Group g : search) {
			if(g.getVisable() || g.getMembers().contains(user.getEmail())) {
				show.add(g);
			}
		}


		model.addAttribute("groupsList", show);
		// model.addAttribute("user", temp );

		return "Group";
	}

	@RequestMapping(value = "/LoadGroup", method = RequestMethod.GET)
	public String preloadEvent(Model model) {
		Group annunaki = new Group("Nörd", "Allir meðlimir nörd. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",true);
		Group bubb = new Group("Bubb og co.", "Allir vinir hans bubba. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",true);
		Group brh = new Group("BRH BOYS", "Bara fyrir boys úr Breiðholti. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",true);
		Group golf = new Group("Golf Crew", "ef þú hefur áhuga á golfi.. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", true);
		Group fjolla = new Group("Fjöllan", "Blöndal ættin. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", false);
		Group bolta = new Group("BumbuBolti", "Bolti fyrir fólk með bumbu. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", true);
		Group afm = new Group("Afmæli", "Vinum mínum sem er boðið í afmæli mitt. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", false);
		Group bio = new Group("Bíóklúbburinn", "Bíó alla þriðjudaga, PEPP! Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", true);
		Group laera = new Group("Study-hópur", "Study hópur í hugbúnaðarverkefni 1. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", false);
		
		
		groupService.addGroup(annunaki);
		groupService.addGroup(bubb);
		groupService.addGroup(brh);
		groupService.addGroup(golf);
		groupService.addGroup(fjolla);
		groupService.addGroup(bolta);
		groupService.addGroup(afm);
		groupService.addGroup(bio);
		groupService.addGroup(laera);

		return "Group";
	}
	
	@RequestMapping(value = "/findUserToAdd", method = RequestMethod.POST)
	public String SearchUser(@ModelAttribute("user") User user, Model model,
			@RequestParam("username") String username) {

		Group currentGroup = groupService.getCurrentGroup();
		System.out.println("calling service function================================");
		List<User> search = userService.findByUsername(username);

		model.addAttribute("userList", search);
		// model.addAttribute("user", temp );

		System.out.println("done looking ================================");

		return goToViewGroup(currentGroup.getGroupID(),model);
	}
	
	@RequestMapping(value = "/addmember", method = RequestMethod.POST)
	public String addMemberToGroup(@ModelAttribute("userInfo") User user,Model model,@RequestParam("userName") String userName,
			@RequestParam("email") String email) {
		
		User new_member = userService.findByEmail(email);
		
		Group currentGroup = groupService.getCurrentGroup();
		
		groupService.addMember(new_member, currentGroup.getGroupID() );
		
		Group updatedGroup = groupService.findGroupByID(currentGroup.getGroupID());
		
		ArrayList<String> memberEmails = updatedGroup.getMembers();
		ArrayList<User> members = new ArrayList<User>();
		
		for(String em : memberEmails) {
			User u = userService.findByEmail(em);
			members.add(u);
			System.out.println(u.getEmail());
		}
		
		model.addAttribute("membersOfgroup", members );
		
		return goToViewGroup(updatedGroup.getGroupID(),model);
	}
	
	@RequestMapping(value = "/joinGroup", method = RequestMethod.GET)
	public String addMemberToGroup(Model model) {
		
		User new_member = userService.getCurrentUser();
		
		Group currentGroup = groupService.getCurrentGroup();
		
		groupService.addMember(new_member, currentGroup.getGroupID() );
		
		Group updatedGroup = groupService.findGroupByID(currentGroup.getGroupID());
		
		ArrayList<String> memberEmails = updatedGroup.getMembers();
		ArrayList<User> members = new ArrayList<User>();
		
		for(String em : memberEmails) {
			User u = userService.findByEmail(em);
			members.add(u);
			System.out.println(u.getEmail());
		}
		
		model.addAttribute("membersOfgroup", members );
		
		return goToViewGroup(updatedGroup.getGroupID(),model);
	}
	
	@RequestMapping(value = "/showUsersToAdd", method = RequestMethod.POST)
	public String showUsersToAdd(Model model) {

		System.out.println("SHOW ALL");
		Group currentGroup = groupService.getCurrentGroup();
		

		model.addAttribute("userList", userService.findAllUsers());
		// model.addAttribute("user", temp );

		return goToViewGroup(currentGroup.getGroupID(),model);
	}
	
	@RequestMapping(value = "/addMember/{email}", method = RequestMethod.GET)
	public String addThisUser(@ModelAttribute("userInfo") User user,Model model,@PathVariable String email) {
		
		User new_member = userService.findByEmail(email);
		
		Group currentGroup = groupService.getCurrentGroup();
		
		groupService.addMember(new_member, currentGroup.getGroupID() );
		
		Group updatedGroup = groupService.findGroupByID(currentGroup.getGroupID());
		
		ArrayList<String> memberEmails = updatedGroup.getMembers();
		ArrayList<User> members = new ArrayList<User>();
		
		for(String em : memberEmails) {
			User u = userService.findByEmail(em);
			members.add(u);
			System.out.println(u.getEmail());
		}
		
		model.addAttribute("membersOfgroup", members );
		
		return goToViewGroup(updatedGroup.getGroupID(),model);
	}
	

	
	
	
	
	

}
