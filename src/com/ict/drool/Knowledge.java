package com.ict.drool;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatelessKnowledgeSession;
import org.junit.Test;

public class Knowledge {

	@Test
	public void test() {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();

		kbuilder.add(ResourceFactory.newClassPathResource("rule.drl", Knowledge.class), ResourceType.DRL);

		if (kbuilder.hasErrors()) System.err.println(kbuilder.getErrors().toString());

		KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());

		StatelessKnowledgeSession ksession = kbase.newStatelessKnowledgeSession();

		Applicant applicant = new Applicant("Mr John Smith", 19);
//		assertTrue(applicant.isValid());
		System.out.println(applicant.isValid());

		ksession.execute(applicant);
//		assertFalse(applicant.isValid());
		System.out.println(applicant.isValid());
	}

	public static void main(String[] args) {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();

		kbuilder.add(ResourceFactory.newClassPathResource("rule.drl", Knowledge.class), ResourceType.DRL);

		if (kbuilder.hasErrors()) System.err.println(kbuilder.getErrors().toString());

		KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());

		StatelessKnowledgeSession ksession = kbase.newStatelessKnowledgeSession();

		Applicant applicant = new Applicant("Mr John Smith", 16);
		assertTrue(applicant.isValid());

		ksession.execute(applicant);
		assertFalse(applicant.isValid());
	}

}
