/*
 * Program name: Example5.java
 * Date: 2016/10/05
 * Update: 2017/10/14
 * Author: Yu-Huei Cheng
 * E-mail: yuhuei.cheng@gmail.com
 *
 * Function:
 *		REHUNT example 5.
 */

package bio.rehunt.examples;

import java.util.*;

import bio.rehunt.rflp.JudgeRFLP;

/**
 * REHUNT example 5.
 * @author Yu-Huei Cheng
 * @version REHUNT v1.2
 * @since JDK1.8.0
 * Description:
 * 		All restriction enzymes including IUPAC format are evaluated.
 * 		The sequence "AATTTCTGG[A/G]CCCTAACGGT" can be recognized by many restriction enzymes including IUPAC format for variation A.
 * 		The function setIUPACenzyme(true) in "JudgeRFLP" class is used.
 */
public class Example5 {
	public static void main(String args[]) {
		// judge the variation if can be recognized by restriction enzymes
		String seq = "AATTTCTGG[A/G]CCCTAACGGT";
		// Sequence
		List<List<String>> cutEnzymesList = null;
		// ----- variation1 and variation2 ----- //
		// cutEnzymesList.get(0): (variation1 and variation2), cutEnzymesList.get(1): (variation2 and variation1)
		// do RFLP for sequence
		JudgeRFLP judgeRFLP = new JudgeRFLP(seq);
		judgeRFLP.setIUPACenzyme(true);
		if(judgeRFLP.isVarSeq()) {
			boolean isCut = judgeRFLP.isCanCut_dNTPs();
			System.out.println("+ strand: " + isCut);
			cutEnzymesList = judgeRFLP.getCutEnzymesList();
			// enzymes
			System.out.println("Enzymes size: " + cutEnzymesList.get(0).size());
			System.out.println("Restriction enzymes which can recognize variation1, but cannot recognize variation2: " + cutEnzymesList.get(0).toString());
		}
		else	// not variation sequence
			System.out.println("The sequence is not a variation sequence.");
	}
}