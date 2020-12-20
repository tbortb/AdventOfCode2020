public class Day2{
	
	public static void main(String[] args){
		System.out.println("Valid Passwords First Part: " + countValidPWsFirstPart());
		System.out.println("Valid Passwords Second Part: " + countValidPWsSecondPart());
	}

	private static int countValidPWsSecondPart() {
		int validCounter = 0;
		for(String entry : getRawData().split("\\r\\n")) {
//			Parse input
			final int firstIndex = Integer.parseInt(entry.substring(0, entry.indexOf("-")));
			final int secondIndex = Integer.parseInt(entry.substring(entry.indexOf("-") + 1, entry.indexOf(" ")));
			final char demandedChar = entry.charAt(entry.indexOf(" ") + 1);
			final String pw = entry.substring(entry.indexOf(": ") + 2);
			
			final char firstChar = pw.charAt(firstIndex - 1);
			final char secondChar = pw.charAt(secondIndex - 1);
			
			//Count occurances XOR the found characters to the demanded character
			if((firstChar == demandedChar || secondChar == demandedChar) && 
					!(firstChar == demandedChar && secondChar == demandedChar)) {
				validCounter++;
			}
		}
		return validCounter;
	}

	private static int countValidPWsFirstPart() {
		int validCounter = 0;
		for(String entry : getRawData().split("\\r\\n")) {
//			Parse input
			final int from = Integer.parseInt(entry.substring(0, entry.indexOf("-")));
			final int to = Integer.parseInt(entry.substring(entry.indexOf("-") + 1, entry.indexOf(" ")));
			final char demandedChar = entry.charAt(entry.indexOf(" ") + 1);
			final String pw = entry.substring(entry.indexOf(": ") + 2);
			
			//Count occurances
			int occurances = 0;
			for (char c : pw.toCharArray()) {
				if(c == demandedChar) {
					occurances++;
				}
			}
			
			if(occurances >= from && occurances <= to) {
				validCounter++;
			}
		}
		return validCounter;
	}
	
	private static String getRawData(){
		return "4-6 b: bbbdbtbbbj\r\n" + 
				"1-6 g: ggvggbgggstg\r\n" + 
				"1-4 s: lssss\r\n" + 
				"13-14 v: hvvcvvvvvvvvvsvvv\r\n" + 
				"3-5 m: lcmmm\r\n" + 
				"3-4 t: stht\r\n" + 
				"5-6 b: dbkbhb\r\n" + 
				"4-7 p: ppfppppq\r\n" + 
				"4-5 j: jjjjj\r\n" + 
				"3-12 s: sskssssssssss\r\n" + 
				"14-15 z: zrndzbmrzzpzzqzj\r\n" + 
				"12-18 l: tllllllllllllplllbl\r\n" + 
				"8-10 b: bdbvqbtbrb\r\n" + 
				"1-3 c: tcqccc\r\n" + 
				"1-2 n: nbnj\r\n" + 
				"5-7 c: ccccccccc\r\n" + 
				"9-10 l: hpmslrlgll\r\n" + 
				"6-9 n: nnnnnnnnb\r\n" + 
				"6-10 r: rmzjlrsxkbw\r\n" + 
				"6-8 r: bzqnnrrrj\r\n" + 
				"4-14 c: mfffvcbtchzrqcn\r\n" + 
				"1-6 f: ffffffffffffff\r\n" + 
				"2-5 f: wxtkf\r\n" + 
				"8-12 b: rdcbbjbzbbpb\r\n" + 
				"8-18 d: ddtdddddddwvdfdsdd\r\n" + 
				"5-8 s: sssmsgpgszms\r\n" + 
				"6-11 x: xxxxxvxxxxxt\r\n" + 
				"17-18 n: jhrnnzpxzngfqrntmnc\r\n" + 
				"13-14 r: rrrmrrrrlrrshvrrr\r\n" + 
				"4-5 h: hhhhrhh\r\n" + 
				"8-10 d: dgwtdsxnncd\r\n" + 
				"9-13 q: qqbpqmqgmqwqbqqqxcgq\r\n" + 
				"2-5 g: gjjcpgg\r\n" + 
				"6-12 t: ttttvttttttrtt\r\n" + 
				"3-9 h: hhhhhhhhsh\r\n" + 
				"15-16 p: ppppsppppppppppz\r\n" + 
				"2-5 c: csccctcccc\r\n" + 
				"11-14 p: pppppppppppppnp\r\n" + 
				"8-9 j: jvbjjjjrjbjj\r\n" + 
				"8-16 b: qklbmbntmvbhxplbbcb\r\n" + 
				"12-13 j: jjjjsjmfjjjkhj\r\n" + 
				"2-13 t: llckxhfmtznptndcsx\r\n" + 
				"6-8 x: dxxxxvxxtt\r\n" + 
				"3-4 d: ddht\r\n" + 
				"3-4 t: ttdtt\r\n" + 
				"11-12 r: rrrrrrrrrrrd\r\n" + 
				"9-10 h: hhhhhhhhgh\r\n" + 
				"3-16 h: hhhhhhhhhhhhhhnhhh\r\n" + 
				"10-11 h: hxhhhdhhhsh\r\n" + 
				"1-7 n: jnfnjnn\r\n" + 
				"3-4 m: msmnpmpf\r\n" + 
				"15-17 t: tpdtttgltvtttztlv\r\n" + 
				"7-10 v: vvpsvpgjzvvvvjs\r\n" + 
				"1-5 p: pxppg\r\n" + 
				"2-7 w: jwhgkgvxcv\r\n" + 
				"13-14 m: pxxmjznmrzdsbbmmfj\r\n" + 
				"1-4 d: ddddd\r\n" + 
				"14-16 r: rrrrrrrrrrrrrwrr\r\n" + 
				"2-5 l: klbtzzlrlslgswhljtq\r\n" + 
				"6-12 c: qccrcpccccccdccccc\r\n" + 
				"2-18 l: llllllllvllllllllkll\r\n" + 
				"18-20 z: zzzzzzzzszqzwzrzzzzn\r\n" + 
				"5-16 c: cbccclcfcncvqztqc\r\n" + 
				"7-11 m: fnwmtsmgpxncnr\r\n" + 
				"6-7 h: hpjrhbhkshnchbhpph\r\n" + 
				"11-12 s: ssssssssssps\r\n" + 
				"6-9 s: jfsmmssssqz\r\n" + 
				"1-15 l: llllllllllllllbll\r\n" + 
				"2-6 g: gggggwgggpggggggg\r\n" + 
				"6-9 j: jjjpjjjjn\r\n" + 
				"9-13 n: nnnnnnnnnnnnnn\r\n" + 
				"10-13 t: cgntllxnvpkjwxtght\r\n" + 
				"2-11 f: xcftbcdcndkgm\r\n" + 
				"10-13 j: jjjjjjjjjjjjvj\r\n" + 
				"9-17 f: rfrffnsffxqflbffvv\r\n" + 
				"6-11 k: kkkkkrwkqckmk\r\n" + 
				"5-7 q: zfqqqqqn\r\n" + 
				"12-13 c: cfcccvccccckccccv\r\n" + 
				"5-15 z: xhzzzzzzzzfzzknzz\r\n" + 
				"18-19 f: jkfksvmfjbdffffffff\r\n" + 
				"8-11 h: hhhhmhhkhsfdg\r\n" + 
				"14-16 s: ssssssdjssssssssssss\r\n" + 
				"15-16 t: jtmjhsxqqmmthmtttm\r\n" + 
				"5-7 h: hkbjhjhh\r\n" + 
				"2-6 n: knprnfnfhhrcnk\r\n" + 
				"3-4 w: snwd\r\n" + 
				"5-11 w: wwwwnwwwwwwwwwwww\r\n" + 
				"2-12 k: bkqjghpktfsk\r\n" + 
				"14-15 v: vvvsvvvvvvvvvxv\r\n" + 
				"8-9 w: fxwwwwwscwl\r\n" + 
				"9-15 c: sbjvvsmdvqknbccxxx\r\n" + 
				"6-15 t: tpwjtdnnldthxvn\r\n" + 
				"13-15 t: tttttrzmzttjttt\r\n" + 
				"3-11 m: mmvmlmmmwfmjx\r\n" + 
				"13-14 s: gskssssssscssssqjssl\r\n" + 
				"5-10 l: bfnmqlldllp\r\n" + 
				"17-18 q: qkwqqqqqqqqqqqrqqqqq\r\n" + 
				"2-5 r: rsvrrq\r\n" + 
				"3-4 j: jjjdj\r\n" + 
				"3-4 m: mtmk\r\n" + 
				"8-9 k: vsvkvkrkc\r\n" + 
				"10-12 t: ttttttcttttgttt\r\n" + 
				"3-4 n: trzw\r\n" + 
				"5-11 q: qqmpsqbxkqq\r\n" + 
				"13-15 s: sqsssnmwqszfsmv\r\n" + 
				"5-6 b: bbbbzvb\r\n" + 
				"5-13 p: pjjhpnqpzpmpfpfp\r\n" + 
				"4-5 l: mgnwlrw\r\n" + 
				"1-7 k: fkzxwkj\r\n" + 
				"1-10 q: qgxqqqqqqg\r\n" + 
				"8-9 s: ssqssssfss\r\n" + 
				"7-8 c: xxcscclccdvcmqcc\r\n" + 
				"2-6 d: xdlmzdzxrpmlnt\r\n" + 
				"3-9 s: sssssnssgbs\r\n" + 
				"7-10 h: sblrrhqrhh\r\n" + 
				"3-5 n: xnndnnnfnw\r\n" + 
				"9-10 l: vllllqlllhllljxlp\r\n" + 
				"2-5 d: ddxzbxk\r\n" + 
				"10-14 m: mmmmmmmmmmdmmmmsmmm\r\n" + 
				"1-2 f: ffffw\r\n" + 
				"14-15 g: wdjhplhrbcxdgpnt\r\n" + 
				"1-2 l: klllllll\r\n" + 
				"10-11 k: ckkhkkvkkkmkkjkwkkwk\r\n" + 
				"7-9 f: ffrhdvftfpjfqffhnfsf\r\n" + 
				"4-5 c: kkjksrmkccg\r\n" + 
				"5-9 r: rrrrhrrrrr\r\n" + 
				"5-6 p: pppppth\r\n" + 
				"4-10 t: kpfwzjtchtbndblrvst\r\n" + 
				"1-5 l: mllllllnllll\r\n" + 
				"13-16 r: rrrvrrrrrrrrzrrg\r\n" + 
				"17-18 x: xxfxxxxxxxxsxxxxxsxx\r\n" + 
				"8-11 w: rwbnqrngcvpgwwww\r\n" + 
				"4-8 z: zzzzzzzzzz\r\n" + 
				"4-9 b: bbvvbbbbr\r\n" + 
				"2-5 x: qlfhxkx\r\n" + 
				"3-8 t: wvptttttttt\r\n" + 
				"1-3 m: hmmmmqmm\r\n" + 
				"17-19 h: nhhhdvhnhrhhhhnhmdh\r\n" + 
				"11-12 s: psszbdpsgfks\r\n" + 
				"6-7 s: sssssshs\r\n" + 
				"10-15 l: mnkdvnvmxljjtggwcl\r\n" + 
				"1-13 j: qjjjjjjjjjjjdj\r\n" + 
				"4-9 l: jxvkwhlmlhdtgwvgsdzz\r\n" + 
				"5-9 c: ccfghhccccgc\r\n" + 
				"10-11 v: vvvvvvvvvvv\r\n" + 
				"7-8 t: cntwzshkzvmrnnkr\r\n" + 
				"1-11 l: tllllllltllll\r\n" + 
				"15-17 l: lllglvctrvllzkllt\r\n" + 
				"3-5 n: ncnnp\r\n" + 
				"2-3 q: jsqqh\r\n" + 
				"4-10 h: hhhhhhhhhvh\r\n" + 
				"16-18 b: bbnbbbbbtbbkktbbzdr\r\n" + 
				"4-6 g: kbggdhgggggggggggfc\r\n" + 
				"12-13 p: cpvcppqpplwpt\r\n" + 
				"5-10 h: fvhhbrhpghchhhhhh\r\n" + 
				"2-5 b: bbvzn\r\n" + 
				"14-15 x: xxxbxnwxxxxzxxh\r\n" + 
				"13-15 n: nnfgdglfnntnjqn\r\n" + 
				"2-4 c: cfccc\r\n" + 
				"3-5 v: vrvvzdvv\r\n" + 
				"17-19 v: vvvvvvvvvvvvvvvvvvsv\r\n" + 
				"1-20 h: hhhhhhhhhhqhhhhhhhhh\r\n" + 
				"4-15 q: qqqtqqqqqqqqqqqqlq\r\n" + 
				"11-13 h: hhkhvhhhhwhgk\r\n" + 
				"8-11 p: ppvppppppptspf\r\n" + 
				"8-9 m: mmmpmmkmdmpkspmg\r\n" + 
				"1-7 m: lcmvggm\r\n" + 
				"6-12 v: tvfstvvpvzsvcv\r\n" + 
				"8-9 n: nnnqnnwrrdzlmnwlznrn\r\n" + 
				"1-5 s: msssms\r\n" + 
				"1-3 v: vpdzvdvgv\r\n" + 
				"6-9 g: drgrfggcg\r\n" + 
				"6-16 x: djpxhxvncxfghsxx\r\n" + 
				"1-3 b: sjbwwxbvtvbkt\r\n" + 
				"6-8 c: cccccstccjhv\r\n" + 
				"1-11 q: qqqpqqqqqqwqqq\r\n" + 
				"9-11 m: vsbmmmmmmmqmmsm\r\n" + 
				"2-7 g: gqggggggg\r\n" + 
				"2-3 m: mrgvm\r\n" + 
				"6-7 c: cccpcfcc\r\n" + 
				"6-10 w: swbngwswnxnww\r\n" + 
				"13-14 r: rrrrrrrrrrwrrgrdr\r\n" + 
				"3-9 v: vctxhxtfvq\r\n" + 
				"2-9 r: jrrcslgplcprlvgthg\r\n" + 
				"2-3 n: hnnnsxclvdj\r\n" + 
				"10-11 h: zrhghhqhgzh\r\n" + 
				"15-18 z: zzzlzzzzzzzzpzqzpzzz\r\n" + 
				"3-8 f: fffffrfl\r\n" + 
				"1-4 l: rllllfl\r\n" + 
				"1-2 n: nnnnnvtnv\r\n" + 
				"17-19 z: zzzzzzzzzzzzzzzzzzqz\r\n" + 
				"13-15 n: nnnznnnnnnznnnn\r\n" + 
				"2-5 c: gcccncjmsncfcntjc\r\n" + 
				"8-9 h: hhhhhhhhbpsfh\r\n" + 
				"7-11 r: lzvvlbrgjgrr\r\n" + 
				"5-11 x: xxxxqxxxxxxx\r\n" + 
				"4-7 p: gqpkmppzpsmtzhfdfpl\r\n" + 
				"3-4 j: jjdjdg\r\n" + 
				"14-16 z: zzzzzzzgjzzzzpzf\r\n" + 
				"1-2 n: nnnvnwnnnnh\r\n" + 
				"4-5 z: jhzzz\r\n" + 
				"5-7 k: kkkkkkf\r\n" + 
				"8-18 z: khzzrzjzmzzvzzpcclm\r\n" + 
				"5-10 m: kjrhwkhmsm\r\n" + 
				"10-16 v: vvvvvvvvvvvvvvvwv\r\n" + 
				"9-10 l: xhvjsmllkcdtldfxlw\r\n" + 
				"8-10 p: ppjvppbpqhpwhppgbp\r\n" + 
				"4-6 m: jlmkhm\r\n" + 
				"1-3 k: gvpklkkkk\r\n" + 
				"15-16 g: ggjggggvgmgtpgcg\r\n" + 
				"1-4 j: jbjwj\r\n" + 
				"1-3 x: xxxpxxdxxhfx\r\n" + 
				"14-16 v: vxmhhdvvfjjqwhtv\r\n" + 
				"6-7 l: lnkchzlwxlp\r\n" + 
				"3-4 v: vvvcv\r\n" + 
				"13-14 p: pbqpppppzbmppc\r\n" + 
				"6-12 p: glqwzprpqbqf\r\n" + 
				"6-12 l: lllllglllllll\r\n" + 
				"8-9 n: nnsnnnndcn\r\n" + 
				"6-8 p: prwppppp\r\n" + 
				"1-10 q: dqqqqqqqqjq\r\n" + 
				"12-16 w: kwtbdnjqmwwxhwcwswkl\r\n" + 
				"11-14 r: rrnjghfrrrshlrq\r\n" + 
				"2-14 w: vwbbvcvgnxdmxl\r\n" + 
				"7-8 g: sqmggkgslkwlvggg\r\n" + 
				"1-6 q: tqqqqqq\r\n" + 
				"2-3 b: bbbr\r\n" + 
				"7-9 b: jnwbswfpbn\r\n" + 
				"4-5 n: nnlct\r\n" + 
				"3-11 s: ssssssssssp\r\n" + 
				"2-6 f: wjlpwf\r\n" + 
				"5-10 g: gggghqgqgb\r\n" + 
				"1-3 p: ppdg\r\n" + 
				"4-7 j: pjnkjjljjj\r\n" + 
				"1-2 v: ghmjzxmtxjxnv\r\n" + 
				"6-14 k: klgdzfmgdwhqdkhcnzm\r\n" + 
				"6-11 z: tgzpzzzzztc\r\n" + 
				"2-12 b: cxsmjbdgdnrb\r\n" + 
				"4-6 v: lxdvvh\r\n" + 
				"3-8 l: pnpdnrll\r\n" + 
				"7-8 m: mzmswvmmbxmzlmwhdvq\r\n" + 
				"13-14 s: khzssssssssszsssss\r\n" + 
				"10-18 d: dmfdlgcxdbzznbrlqn\r\n" + 
				"13-14 j: jjjjjjjjjjjjdpjj\r\n" + 
				"15-17 j: jjjjjjjjjwjsqjwjj\r\n" + 
				"10-15 x: xxfxkzxxhxxxxxvxxw\r\n" + 
				"7-14 c: wcccwcmmcccccxhcccc\r\n" + 
				"2-7 z: zmzvfzlszr\r\n" + 
				"7-8 k: jjkrklrkkv\r\n" + 
				"8-9 r: rrrrrjrtz\r\n" + 
				"2-3 w: tvws\r\n" + 
				"1-5 b: bbbjm\r\n" + 
				"1-2 q: tqqjf\r\n" + 
				"5-10 j: wlgjghjhjljwtpcdkqwk\r\n" + 
				"2-5 c: dzpkc\r\n" + 
				"5-6 m: mbvmkm\r\n" + 
				"4-15 k: stjkjvvxrmwdpkwsjqvc\r\n" + 
				"6-9 h: hwkgjplmhxwgvnbhwh\r\n" + 
				"12-13 z: zzzzzzzzzzzzz\r\n" + 
				"7-8 q: qqqqqqqqq\r\n" + 
				"2-5 c: clcwmccczclcccc\r\n" + 
				"2-5 l: jlcgfbflklvpfqxtwgg\r\n" + 
				"5-7 n: nnnnnnvnnnnnn\r\n" + 
				"3-5 f: gfktfffqvgltsbff\r\n" + 
				"10-16 p: jppbttppzpqppppp\r\n" + 
				"2-3 m: zmdm\r\n" + 
				"4-6 j: zsmtjjdnrpp\r\n" + 
				"17-18 j: hvvmrkfnnkvrjtjhjj\r\n" + 
				"12-15 d: dtddddddddtwxgld\r\n" + 
				"8-12 r: rdzrwfgrmxwttknxz\r\n" + 
				"6-7 s: rssbktxsgd\r\n" + 
				"11-13 d: ddddmwddddxddndc\r\n" + 
				"3-6 p: ppcpspfp\r\n" + 
				"12-15 j: jjjjjjgjjjjcjlzj\r\n" + 
				"8-12 v: tgjkwfbsxzzvvpmfs\r\n" + 
				"6-7 z: trbfbdz\r\n" + 
				"4-6 v: vvvvvpvv\r\n" + 
				"8-16 p: pnvppdpjppppppph\r\n" + 
				"8-9 z: lzzzzpdzk\r\n" + 
				"1-4 t: qttzz\r\n" + 
				"2-3 d: dhdd\r\n" + 
				"5-8 m: mmmkmmxmkj\r\n" + 
				"2-12 f: hfhzkwdmrlqvfkn\r\n" + 
				"5-6 h: hhhhhph\r\n" + 
				"14-15 b: bbbbxbbbbbbbbbh\r\n" + 
				"2-3 v: vvcj\r\n" + 
				"12-19 d: ddvdwwqdddcdtdmwdqp\r\n" + 
				"3-4 s: ssjssssssss\r\n" + 
				"2-6 c: wzzxqcdcnlgcph\r\n" + 
				"11-12 j: jjdrcjzjkjcs\r\n" + 
				"4-9 z: bzzzzzzxzz\r\n" + 
				"2-8 b: gjbfkxhb\r\n" + 
				"1-3 c: cpksst\r\n" + 
				"1-5 h: hhjhh\r\n" + 
				"14-15 j: jjjjjjjjjjjjjjr\r\n" + 
				"8-9 n: pcndxcfknfbnnls\r\n" + 
				"10-13 k: kkkqzkwbkkkrtn\r\n" + 
				"4-5 r: rzrrrnrj\r\n" + 
				"13-15 p: ppppppppppppppt\r\n" + 
				"3-6 j: fjqqzzzjm\r\n" + 
				"2-9 m: zmjhctkmf\r\n" + 
				"5-6 s: ssmjss\r\n" + 
				"3-4 c: jlfd\r\n" + 
				"8-12 d: qbddfhnddzgvddddd\r\n" + 
				"6-7 p: xfppppcppppxgp\r\n" + 
				"8-13 s: sssssssfssssssss\r\n" + 
				"13-17 g: xskktsjxlvgfxtzzgfj\r\n" + 
				"2-4 q: qqtwfqqnkvbvbhzs\r\n" + 
				"1-5 j: cjmjs\r\n" + 
				"4-5 c: tvccnc\r\n" + 
				"3-14 m: kkfhmnkkmztxtmn\r\n" + 
				"11-15 x: xxxxxpxmxxvbxxxvx\r\n" + 
				"9-11 l: nhgzwmmrkqhblnk\r\n" + 
				"7-10 x: xxxxxdmxxxxxxxx\r\n" + 
				"13-14 v: vvvvvvpvvvjvvcvv\r\n" + 
				"16-17 n: nnnnqnnbnnnnnnnpn\r\n" + 
				"3-4 j: jvjj\r\n" + 
				"15-16 q: zlqsgvpztknqjqqwqvf\r\n" + 
				"3-4 s: sssrsssdss\r\n" + 
				"11-13 g: ggqggmggswggdk\r\n" + 
				"1-4 t: jmtzttztqt\r\n" + 
				"2-3 v: vvvv\r\n" + 
				"11-13 g: cgjgxgggkgbggxg\r\n" + 
				"4-6 g: ggggqlhgmz\r\n" + 
				"8-15 g: prvxwzkvdhgkjlg\r\n" + 
				"6-9 g: gggggnsjlg\r\n" + 
				"12-14 p: mmvlpzkmpgtpvj\r\n" + 
				"7-10 k: kkkxkkjkkkdkkkp\r\n" + 
				"14-16 b: zmztqsrgvjjmswzkbnk\r\n" + 
				"1-2 x: xxbxxxxhx\r\n" + 
				"2-5 l: tlhsx\r\n" + 
				"3-5 x: xxxxn\r\n" + 
				"4-12 c: vdnmtmqwnxkcldc\r\n" + 
				"4-8 x: xxxxjglx\r\n" + 
				"5-13 s: vsssspszssssnsss\r\n" + 
				"3-6 k: kkhkkkknb\r\n" + 
				"3-5 t: pttqtwnprt\r\n" + 
				"10-14 m: ttjqvzmgmmjqzkd\r\n" + 
				"1-5 b: bbbbpbbb\r\n" + 
				"10-15 d: wdjrhvfngdtlkdl\r\n" + 
				"6-7 w: trxwdwww\r\n" + 
				"2-4 n: snxqlgtsmdnnjgwrgmms\r\n" + 
				"16-18 l: klslpljllqlcslqqll\r\n" + 
				"4-7 t: tttwzttjt\r\n" + 
				"9-10 f: ffffffffwf\r\n" + 
				"8-15 h: trhgxjchhxvvhqp\r\n" + 
				"8-12 w: wwwwwwwqwwwg\r\n" + 
				"12-13 x: xxxxxxxxsffqlxx\r\n" + 
				"5-7 k: kkkklkkkktkk\r\n" + 
				"1-7 m: wkmmqmmhf\r\n" + 
				"12-13 h: mhhchwhhhzhhcvh\r\n" + 
				"7-11 k: kkkkkkwkkkgkk\r\n" + 
				"4-6 l: hdlbll\r\n" + 
				"8-12 v: fvvvvvvvrvvv\r\n" + 
				"2-9 h: hzhhhhhhhhhhhhr\r\n" + 
				"6-8 b: qbqjpbbbdsshv\r\n" + 
				"2-3 h: hwhl\r\n" + 
				"4-7 l: mdllxjgdw\r\n" + 
				"3-9 f: rwffzfkpwbzp\r\n" + 
				"3-5 t: ttnttt\r\n" + 
				"7-10 c: mpcccpndqc\r\n" + 
				"6-7 h: fhhhljh\r\n" + 
				"2-7 v: pnvzcns\r\n" + 
				"1-3 v: vvgv\r\n" + 
				"5-9 s: ssssshsspsssssss\r\n" + 
				"4-6 j: mjjjjq\r\n" + 
				"5-14 h: hwbqghmvmmnvhhrqmj\r\n" + 
				"5-6 s: wctjsh\r\n" + 
				"7-8 s: sssscsjs\r\n" + 
				"14-17 v: vvvvvvvvvvvvvvvvv\r\n" + 
				"14-15 w: wxwwwwwwfwwwwsw\r\n" + 
				"6-7 v: ksvvvlpvv\r\n" + 
				"7-18 s: cssstsvsscshsstsss\r\n" + 
				"5-6 b: zzwbpm\r\n" + 
				"6-7 r: bvtmpkxspskr\r\n" + 
				"6-7 v: lvxrvqv\r\n" + 
				"15-17 c: ccccccccccccccccccc\r\n" + 
				"8-12 r: ghxpwhxcqjrr\r\n" + 
				"6-10 k: kzbcdkndqm\r\n" + 
				"5-6 s: tpsxss\r\n" + 
				"1-5 p: qlrlp\r\n" + 
				"4-8 q: qqqkqqqz\r\n" + 
				"7-11 v: vgvsxvwvlxv\r\n" + 
				"2-5 b: bgkbb\r\n" + 
				"3-18 j: jjsplxjxgqjfjrjxjjlx\r\n" + 
				"6-10 k: kxkhkkjkkrvkkk\r\n" + 
				"7-16 t: ttttttzttttttttbtttt\r\n" + 
				"1-7 l: ptzptslrjgwlfgwq\r\n" + 
				"8-10 v: vvqvvvvvvvv\r\n" + 
				"3-5 z: zzzhz\r\n" + 
				"6-7 c: cbrctgc\r\n" + 
				"5-16 l: llllxlllllllllllll\r\n" + 
				"6-7 c: chxclqcdrh\r\n" + 
				"1-10 c: jcmcccccwcccccjbvc\r\n" + 
				"8-14 h: zhhvhhhhhhhhhv\r\n" + 
				"4-7 n: rnnnnnfnnnnnvn\r\n" + 
				"10-12 w: wwwwwwwsgtwww\r\n" + 
				"5-8 c: cmbcctzcj\r\n" + 
				"5-7 f: fffskrf\r\n" + 
				"5-6 l: lllmzl\r\n" + 
				"7-14 m: mmmmmmmmmmmmmmmmmmm\r\n" + 
				"1-9 f: jfffffffzvffff\r\n" + 
				"2-5 g: ggmng\r\n" + 
				"16-17 x: xxxxxxxxxxxxxxxlx\r\n" + 
				"4-10 n: npkgjcfnnnnn\r\n" + 
				"1-13 d: bhkjgsnzxkdgwbdv\r\n" + 
				"6-7 f: ncqfzff\r\n" + 
				"7-10 h: hqhhhhhjhhh\r\n" + 
				"2-4 v: vnvvv\r\n" + 
				"1-6 w: thlmdwgwgtswvtx\r\n" + 
				"3-7 d: ddlkhvfdnpbdr\r\n" + 
				"1-4 q: qbfq\r\n" + 
				"2-6 f: rzfmfrjgcfjk\r\n" + 
				"10-16 b: bbbbblbbbkbbbbbbwqb\r\n" + 
				"13-14 j: jjhcjnkgvrnwjp\r\n" + 
				"5-12 l: lgqwvrlwcllllv\r\n" + 
				"4-8 j: jjgpdjssspjfdbt\r\n" + 
				"1-9 h: hhhhhhhhwhhh\r\n" + 
				"4-6 p: psmppt\r\n" + 
				"2-3 h: zhhhk\r\n" + 
				"2-6 b: bbbbbmbbvb\r\n" + 
				"7-9 z: zzzzzzgzdzz\r\n" + 
				"8-9 d: ddgdmdwddd\r\n" + 
				"2-6 s: nssssv\r\n" + 
				"18-20 x: xxxxxxxxxxxxxxxxxvxx\r\n" + 
				"9-10 m: dzckmrbhcmwvkcxmlx\r\n" + 
				"10-11 v: vwvvvvwvvghvn\r\n" + 
				"3-6 d: wcwxddjhnljfntj\r\n" + 
				"13-15 v: vvvvvvvvvvvvcvc\r\n" + 
				"1-5 x: xxfxfxxkx\r\n" + 
				"7-8 w: wqzjzwwwtw\r\n" + 
				"2-4 f: flgl\r\n" + 
				"3-6 n: ncfngngdnm\r\n" + 
				"5-7 k: kdkmbkkkkxk\r\n" + 
				"5-6 x: xxvxth\r\n" + 
				"5-6 r: rrhhzr\r\n" + 
				"4-6 b: bbbrbbbbbmb\r\n" + 
				"12-13 q: qqqqqqqqqzqkqp\r\n" + 
				"6-14 n: mlbflnrbhlhpdrfln\r\n" + 
				"9-12 q: qqqqqqqqqqqwq\r\n" + 
				"3-4 k: rkncnbk\r\n" + 
				"1-3 j: jjpj\r\n" + 
				"8-9 v: vjvczrvvm\r\n" + 
				"9-16 m: tmnmmmxmbmmmrtmmr\r\n" + 
				"9-11 q: qqqqqzqqsjxq\r\n" + 
				"3-5 h: hhhhcs\r\n" + 
				"11-12 k: kkkkkkkkkkkvqk\r\n" + 
				"11-12 x: xlxxxjjxxxpx\r\n" + 
				"1-12 n: nngtnhlnjfnf\r\n" + 
				"5-7 p: ppptppppp\r\n" + 
				"13-14 l: lllmlflllhllpm\r\n" + 
				"13-14 m: vdkmrdfzmkknmp\r\n" + 
				"13-15 s: ssssssqssssscssss\r\n" + 
				"5-11 h: hhhlxhhhhhhshh\r\n" + 
				"10-11 s: ssssssssssgsssss\r\n" + 
				"6-7 q: kqqqqmqnqq\r\n" + 
				"8-13 l: llllllltlllljll\r\n" + 
				"9-12 j: jjjjjjjjjjjlj\r\n" + 
				"7-11 s: gstcncsssscssssss\r\n" + 
				"4-6 x: lrtjfnhmpmxj\r\n" + 
				"9-20 c: cttccccccnccclcccccc\r\n" + 
				"1-8 w: cwwwwwwwwww\r\n" + 
				"12-13 n: nnnnnnnngnnnnn\r\n" + 
				"1-5 p: pfqwcpnppppwwpqppp\r\n" + 
				"7-8 g: gggsgglghg\r\n" + 
				"6-7 g: gggggggg\r\n" + 
				"4-10 s: ssssssssssss\r\n" + 
				"1-2 n: njsnnln\r\n" + 
				"7-8 z: gzczzwdzkkzz\r\n" + 
				"2-8 b: bbbwjfbh\r\n" + 
				"6-8 r: rrrrbrrbr\r\n" + 
				"2-5 k: lkkkkl\r\n" + 
				"2-3 c: swcgjcm\r\n" + 
				"2-10 t: ttttttttttt\r\n" + 
				"12-13 l: lllllxllllllqhl\r\n" + 
				"2-9 l: qtqxdpqqlwhqwlr\r\n" + 
				"1-5 q: qqxrn\r\n" + 
				"10-11 k: kkkkkkkkkckk\r\n" + 
				"1-2 f: ffff\r\n" + 
				"3-4 r: rrxr\r\n" + 
				"8-9 p: lppppxpsp\r\n" + 
				"2-5 s: ssstchlrds\r\n" + 
				"11-15 m: mmmmmmmmmmmmmmmmm\r\n" + 
				"14-17 k: kkkkkkkkkkgkkkktbkk\r\n" + 
				"1-2 x: xlxx\r\n" + 
				"9-10 w: wwcwptczwzzd\r\n" + 
				"1-3 c: ccgcccccccccccccc\r\n" + 
				"4-5 h: nhhhvh\r\n" + 
				"8-16 l: hlllfllllmltlhlldl\r\n" + 
				"4-5 w: wgwfw\r\n" + 
				"6-15 p: pjpbfrmxqgkxkbqhj\r\n" + 
				"12-17 l: llmtllnlllllllllnns\r\n" + 
				"8-15 n: zjnxzndnznklxzjlx\r\n" + 
				"6-9 r: wpsmstnkgtrmng\r\n" + 
				"3-7 s: csvhxhsgvrsrn\r\n" + 
				"10-15 h: hchhhdhkhghlhgsh\r\n" + 
				"2-9 c: mzbmtccktc\r\n" + 
				"3-4 x: xlzvxg\r\n" + 
				"12-14 k: zmkskknwkkkmkkwkgkkk\r\n" + 
				"4-9 r: vqrrrrdzpl\r\n" + 
				"3-4 g: ggvbxg\r\n" + 
				"5-8 q: xtrqrmqq\r\n" + 
				"16-18 l: zllllllllllllllwlnll\r\n" + 
				"6-7 s: zsqszss\r\n" + 
				"3-4 g: wghgpg\r\n" + 
				"1-6 z: hzzzzrz\r\n" + 
				"3-8 h: hthfqtccnq\r\n" + 
				"15-18 p: ppppppcpppppppnppppp\r\n" + 
				"3-4 l: qplkdmjntlghjlpxlq\r\n" + 
				"10-12 q: xzqkxdvgrqxqqzzxgjj\r\n" + 
				"6-9 q: qqqvsvqqxq\r\n" + 
				"12-13 g: shgcnjlgvcgqg\r\n" + 
				"5-10 l: llklplllmlsl\r\n" + 
				"3-12 l: vllqfzwnsqslpnvrbkh\r\n" + 
				"14-16 g: gjggggggggggggbzcggg\r\n" + 
				"5-11 m: ssmsmbnspmm\r\n" + 
				"11-13 v: mkqvvvvvmcvvz\r\n" + 
				"2-3 k: mkkchtzqsvkbclgxn\r\n" + 
				"4-7 r: rphrrnrrqwknrktrgsg\r\n" + 
				"6-10 z: vpjhzzzkqzjl\r\n" + 
				"16-18 c: ccccccccccccccchccc\r\n" + 
				"1-10 v: qvvvvzvvvvvv\r\n" + 
				"5-7 j: jjrjjjj\r\n" + 
				"14-16 l: zlgdrlqllgpllfhh\r\n" + 
				"3-6 l: llmllll\r\n" + 
				"3-4 l: smdl\r\n" + 
				"4-11 h: kgqhcpvrbldrhbq\r\n" + 
				"1-15 j: ljjjjjjjjjjjjjjj\r\n" + 
				"7-14 c: ccccccccccccccc\r\n" + 
				"2-10 v: vzvjvvvvvvvvv\r\n" + 
				"4-9 p: flbpmqmhkpt\r\n" + 
				"10-12 q: rtdrqmpcsqrhqqchqczw\r\n" + 
				"16-19 w: vlwxgtmjwrzvqgdwbdw\r\n" + 
				"8-15 c: gkcccslctcmszhc\r\n" + 
				"3-7 f: hhffhbbtbwzw\r\n" + 
				"4-9 s: msbsxssds\r\n" + 
				"13-15 p: pppppppppcpppxldp\r\n" + 
				"6-7 m: mmmmmqmm\r\n" + 
				"11-12 m: mxmmzwmmmdqpmp\r\n" + 
				"7-12 l: gncmgzxlqcllqgt\r\n" + 
				"12-14 t: tttttttttttdtt\r\n" + 
				"2-6 f: ffffffbrfffp\r\n" + 
				"14-17 h: hhdhpphhhhhhkhhxqph\r\n" + 
				"7-9 x: xxxxxxxxqxxxxxx\r\n" + 
				"5-18 j: vlwgjljtljtrdbxjnjwm\r\n" + 
				"5-7 n: jmncnsndnbwx\r\n" + 
				"8-9 r: rrrrrrrrr\r\n" + 
				"11-17 j: jjjjjjjjjjjjjjpjr\r\n" + 
				"5-6 x: xxxxjt\r\n" + 
				"13-15 l: nshmnjgzhmjdzvl\r\n" + 
				"9-10 r: wmsvzxsrqnnhfr\r\n" + 
				"8-11 k: kkkxxrkpktg\r\n" + 
				"1-7 r: rrrrrrrfrrrjwrd\r\n" + 
				"5-7 t: rztvtvplbrk\r\n" + 
				"2-7 w: wwwwwwsw\r\n" + 
				"1-2 g: sgggk\r\n" + 
				"12-13 j: jjjjjwjjjjvvjjjrjs\r\n" + 
				"1-2 c: cccccc\r\n" + 
				"3-5 g: khgzr\r\n" + 
				"9-16 b: bbbbbbcbsbbbbbbb\r\n" + 
				"12-13 z: zzzzzzzzzszkz\r\n" + 
				"4-5 r: rkrrrr\r\n" + 
				"1-2 t: tgbqtddbmq\r\n" + 
				"1-2 w: wkwwwww\r\n" + 
				"14-15 q: qqdqqqqqqqqhqnb\r\n" + 
				"6-7 r: rrrrrdmrr\r\n" + 
				"8-9 j: jjjjjjjqhjjjjj\r\n" + 
				"3-6 t: gwmlntffstzllvs\r\n" + 
				"6-8 h: hhhhnhhhqh\r\n" + 
				"9-11 w: cwcwwwwwgxwwbw\r\n" + 
				"5-9 w: wwwwcwwww\r\n" + 
				"8-12 k: snjmkkhrgkkzkkpskk\r\n" + 
				"3-6 q: lvqjqlq\r\n" + 
				"3-4 z: zzzn\r\n" + 
				"9-12 t: dvmvhttxtmzhrr\r\n" + 
				"3-7 k: kkkkkkskkkkkk\r\n" + 
				"6-15 v: vqvvvdvvvvbvvvvvvvvv\r\n" + 
				"3-4 z: jzzzzzdk\r\n" + 
				"8-12 b: bbbbbbbbbbbs\r\n" + 
				"3-9 m: nvhwmwgmmqkbmmmzb\r\n" + 
				"8-10 r: npwjcgwrwcrx\r\n" + 
				"1-5 r: rxdrr\r\n" + 
				"6-9 p: ppppppsbkmppkp\r\n" + 
				"1-4 j: jjjqjjjz\r\n" + 
				"6-7 b: rblbbbbbbp\r\n" + 
				"5-9 t: tttttttttf\r\n" + 
				"8-9 c: czcccccccc\r\n" + 
				"13-14 j: jjjbjjtbjjjjjj\r\n" + 
				"3-8 p: pwppzqvp\r\n" + 
				"3-12 m: mmzmmmmmmmmmmm\r\n" + 
				"3-9 d: ddjddddddqddd\r\n" + 
				"3-4 q: qqfq\r\n" + 
				"6-14 m: mmmmmbmmmmwmmlmmmm\r\n" + 
				"3-4 c: glgzc\r\n" + 
				"6-7 t: ttttttt\r\n" + 
				"1-4 s: sssbs\r\n" + 
				"5-8 r: drrkrrrzrrrr\r\n" + 
				"10-12 q: rvqfqqkllqqqlfrq\r\n" + 
				"11-13 s: szsssssssssssss\r\n" + 
				"8-11 t: tttttttsttvt\r\n" + 
				"11-15 j: zjjjjjjjjjjjjjjjjj\r\n" + 
				"2-4 s: dvfs\r\n" + 
				"3-4 q: zhpq\r\n" + 
				"10-11 c: cccccccccckc\r\n" + 
				"5-11 h: pnrjhtdlkzvhh\r\n" + 
				"5-9 l: nlllxgnrlllllllmq\r\n" + 
				"3-4 f: gfff\r\n" + 
				"8-9 g: grgggggbg\r\n" + 
				"3-4 j: pfwjhh\r\n" + 
				"2-5 l: jlfjr\r\n" + 
				"2-4 l: lblv\r\n" + 
				"3-10 q: qqvzhnqqhqvqq\r\n" + 
				"11-15 t: tfttttttktwttts\r\n" + 
				"12-14 b: gqptrzwclbdbfqd\r\n" + 
				"1-4 r: crrprr\r\n" + 
				"5-13 v: qvdvvvdnrqmrqp\r\n" + 
				"9-12 r: rwrrlsrrsrrjgdnrrr\r\n" + 
				"4-6 c: ccldccnp\r\n" + 
				"16-17 q: qqqqqpqqqqlqqqqmlq\r\n" + 
				"2-8 w: wwwwwwwhwmwws\r\n" + 
				"3-6 m: dmmbmmdmkxm\r\n" + 
				"6-13 t: xflrtblvcvfxnlf\r\n" + 
				"2-6 m: pmnsmm\r\n" + 
				"13-15 k: kstfvnkkgfvvkbk\r\n" + 
				"4-10 w: jqwcwlcwcwvqbfzfzfm\r\n" + 
				"1-5 d: ddndbmjxhfqqn\r\n" + 
				"13-16 p: pzvbszhqtpklpkpdw\r\n" + 
				"2-4 t: thttwmxjsbtp\r\n" + 
				"8-10 s: zbsvjcssfmf\r\n" + 
				"3-5 l: lltlwlllll\r\n" + 
				"12-14 g: hgfvvfpnrvpfggnss\r\n" + 
				"3-13 q: cjmbvgxchmqdqcvc\r\n" + 
				"12-16 j: cjjjjjjjjjjqjjjjjj\r\n" + 
				"1-5 m: kqrgm\r\n" + 
				"11-14 x: xcjpwbrrffxkfxh\r\n" + 
				"12-14 c: kgfnccxqczkcjkcc\r\n" + 
				"3-4 f: sfftf\r\n" + 
				"1-3 f: ffdz\r\n" + 
				"12-14 t: xftfxmkttdsttg\r\n" + 
				"4-9 f: ffhcgfffffff\r\n" + 
				"9-10 b: zjlbbsbzbx\r\n" + 
				"9-14 m: hhxmlmmmzmmtmm\r\n" + 
				"3-5 t: tkcpzjwr\r\n" + 
				"6-9 k: wkfdwflgrntrknsr\r\n" + 
				"1-4 l: gfml\r\n" + 
				"9-10 z: zzzzzzzzzrzzzz\r\n" + 
				"9-11 h: hhhhhhhhhhzhh\r\n" + 
				"1-9 k: kkkkkkkkzkkkkkkk\r\n" + 
				"2-7 h: sswmmkhkvhw\r\n" + 
				"2-5 m: pmbnnmzrkk\r\n" + 
				"9-12 f: xhpfbfdffkfw\r\n" + 
				"3-4 g: gfwg\r\n" + 
				"11-12 n: nnnnnnnnnnnpnnnxn\r\n" + 
				"5-6 d: dddddgddd\r\n" + 
				"7-9 j: cbjgnjqjgj\r\n" + 
				"9-14 r: rrrrrrrhrrrrrzbrr\r\n" + 
				"4-5 p: prphk\r\n" + 
				"2-4 d: dpdd\r\n" + 
				"5-15 p: zjsppzhqqgqspcppqpps\r\n" + 
				"2-7 r: rrrrrrfwrr\r\n" + 
				"1-3 h: hhqh\r\n" + 
				"14-16 g: zgvdgspkjrrvcgdlxg\r\n" + 
				"4-6 c: psgqccccvc\r\n" + 
				"9-14 q: qdqjqmttdtcqggqpqn\r\n" + 
				"13-18 f: ffffffffffffgffffff\r\n" + 
				"8-9 g: gggggggggggg\r\n" + 
				"11-12 x: xxxxxxxxxxxr\r\n" + 
				"2-17 c: cxcccfchcccccccbbcm\r\n" + 
				"7-11 b: nwbrzndvrfxwt\r\n" + 
				"3-4 x: xhwxxxv\r\n" + 
				"16-17 r: rzrrnrrrvxrrzrrrrrr\r\n" + 
				"2-3 f: zcvgbmxvwp\r\n" + 
				"5-6 b: fwbbbf\r\n" + 
				"6-10 m: mmmmmpmmmw\r\n" + 
				"2-4 n: bnnvndbpvzj\r\n" + 
				"3-4 t: dftfhdngqp\r\n" + 
				"1-2 v: vtvvvvvvvvv\r\n" + 
				"2-3 v: vgvv\r\n" + 
				"9-10 s: tsvsshsssgssssmsksss\r\n" + 
				"6-7 t: ttttttxt\r\n" + 
				"3-4 c: jcrc\r\n" + 
				"5-8 l: ztlmjljlb\r\n" + 
				"4-5 w: bwwwww\r\n" + 
				"11-14 r: rrrbrrrrrrnrrrs\r\n" + 
				"10-16 z: zzzzznzzzwzzzzzzzz\r\n" + 
				"7-13 m: mmmmmmfmmmmmmmmmmmmm\r\n" + 
				"15-19 w: fflzcwftmcswcwwnwts\r\n" + 
				"10-19 b: bjbbbbbbmwbbbbbbbbtb\r\n" + 
				"14-16 x: xxxxpxxpxxqxdqxxxx\r\n" + 
				"8-13 r: rkzrjbxrgwkhnb\r\n" + 
				"5-18 r: rrrzfkrrrrrrrrtrrnrr\r\n" + 
				"4-5 b: bbbfzb\r\n" + 
				"6-10 q: qnscxqqfqb\r\n" + 
				"8-13 w: wwwwwwwfwwwwwwwwww\r\n" + 
				"10-11 n: scvnsnpgnjnmdpnwct\r\n" + 
				"7-11 p: pjpppppdqpjpfppsptp\r\n" + 
				"7-9 n: jfsvclhfm\r\n" + 
				"3-8 h: whsggqscd\r\n" + 
				"2-12 r: mrmpxhrqsdmqpjshvck\r\n" + 
				"2-4 g: gdgggg\r\n" + 
				"7-12 s: ssssssssgsss\r\n" + 
				"7-11 l: dlklllnjlslbl\r\n" + 
				"5-11 k: kkkkkkkkkkkkkkk\r\n" + 
				"6-9 g: dhtvcgmfrjhk\r\n" + 
				"4-5 m: lmmmhmsmmmmmcmmmmzmm\r\n" + 
				"11-13 t: zgtnkjzmtkttmtkc\r\n" + 
				"6-7 b: bbbbbbv\r\n" + 
				"3-4 q: qqcq\r\n" + 
				"12-16 z: zzzszjzszzczmxtzzcl\r\n" + 
				"2-5 w: wwfhp\r\n" + 
				"1-2 d: gddkd\r\n" + 
				"5-12 f: fwqgbvrcfmwb\r\n" + 
				"2-5 w: bnxcw\r\n" + 
				"3-15 t: ncwftppphsxvztttjs\r\n" + 
				"7-10 p: ppnsppkcppsp\r\n" + 
				"5-6 v: vvrdvv\r\n" + 
				"5-6 z: hczwbzz\r\n" + 
				"3-12 p: gcphfgmzfkflspmxg\r\n" + 
				"14-19 m: jmfmfjpvbmfmmrdkdnzp\r\n" + 
				"6-7 p: pdwzppppp\r\n" + 
				"4-7 b: bbbnbbqbb\r\n" + 
				"7-8 r: frrrrrxxr\r\n" + 
				"8-18 b: jbphpzgvnppwhkxfzs\r\n" + 
				"1-5 c: pvhcc\r\n" + 
				"4-8 z: fzznzjzztstzxrz\r\n" + 
				"5-10 v: jvvwvvvlvlvqc\r\n" + 
				"7-14 p: svgrzfpxkdpbhph\r\n" + 
				"5-7 n: nncmvkn\r\n" + 
				"11-12 r: rrlrbrrrvrrr\r\n" + 
				"1-5 r: vtngrndhqf\r\n" + 
				"2-4 k: knjp\r\n" + 
				"11-14 h: hhghhhhhhhxhhwhhh\r\n" + 
				"16-18 r: rrrrrrrrrrrrrrrpnb\r\n" + 
				"10-14 d: dpddbvdtdmxfdddd\r\n" + 
				"2-4 t: cztt\r\n" + 
				"5-6 r: rzrprd\r\n" + 
				"2-5 n: ngwdngc\r\n" + 
				"1-6 q: qqqzzwwqqqkqqq\r\n" + 
				"7-8 l: lllzllpxl\r\n" + 
				"1-4 b: kmltzzjzbppgwq\r\n" + 
				"1-4 t: ttttb\r\n" + 
				"3-4 p: dkxpcph\r\n" + 
				"7-15 z: zzzzzzhzzzzzzzzzz\r\n" + 
				"4-7 c: cdljfccm\r\n" + 
				"3-8 p: hbpxhlmc\r\n" + 
				"4-5 w: wwwlw\r\n" + 
				"14-15 b: lbqbbbkgbbwfbdb\r\n" + 
				"6-10 j: jtjjvpwwthwcsj\r\n" + 
				"5-8 t: ltvtttbtqxtzq\r\n" + 
				"12-13 t: ttttttttjttztxt\r\n" + 
				"16-18 p: ppppppppppppppxpxbpp\r\n" + 
				"4-7 n: nnnrnnnnt\r\n" + 
				"1-2 r: rfrr\r\n" + 
				"5-6 g: ggggvggg\r\n" + 
				"3-4 s: ssbw\r\n" + 
				"3-4 l: ldll\r\n" + 
				"8-10 m: mmmmvmmcjkmg\r\n" + 
				"10-18 w: wwvwwvwwhwwjwwwlwxcm\r\n" + 
				"1-2 x: cxxxxxxxxxxxxx\r\n" + 
				"1-5 b: bbbbkbbb\r\n" + 
				"12-14 z: zwqzrrzzvqqzzszrx\r\n" + 
				"1-5 z: lzzfzzzfz\r\n" + 
				"16-17 t: ftgstrgptwmptxrzt\r\n" + 
				"9-10 b: bbbbbbbzbbbb\r\n" + 
				"8-14 w: wwwwwwwjwwwzwzww\r\n" + 
				"3-4 h: qhnh\r\n" + 
				"2-12 d: dnddddkddddzdxdddd\r\n" + 
				"5-17 x: xxxxxxxxxxxxxxxxx\r\n" + 
				"9-10 h: hhhhtqhhhrh\r\n" + 
				"6-7 p: pfmppppp\r\n" + 
				"5-8 v: vbvvvvvs\r\n" + 
				"4-5 h: qhfhqcb\r\n" + 
				"3-12 d: dlddlhhwvcrdrxwpt\r\n" + 
				"2-3 n: nnwnp\r\n" + 
				"4-8 g: ggggjgfgzgdglgg\r\n" + 
				"4-9 h: vrghsphxhxzsxw\r\n" + 
				"12-18 z: qrzzzfwdcwnzdzkckz\r\n" + 
				"6-8 v: zvmlqwwh\r\n" + 
				"10-14 p: pppxwpndfpwppdpptmpp\r\n" + 
				"12-15 q: qqnqkqkqjgrcqfq\r\n" + 
				"2-4 n: pnszjnnn\r\n" + 
				"2-3 c: zkctcfc\r\n" + 
				"17-20 l: lvjlcclllslzllllwgll\r\n" + 
				"16-17 k: dfgskkfkkkfjhfvfks\r\n" + 
				"1-3 t: tjttltt\r\n" + 
				"2-3 b: bbzbb\r\n" + 
				"8-15 t: dtttttsttlttttzlttj\r\n" + 
				"13-14 v: vvkvvjvgwvvvkvf\r\n" + 
				"7-8 v: tvvvvvvhv\r\n" + 
				"3-10 d: bxktdrtddtdtsh\r\n" + 
				"4-12 j: npwxjjjjbjkq\r\n" + 
				"1-4 l: tlllll\r\n" + 
				"12-13 b: lbhpxbbbvbbbqbbbsbb\r\n" + 
				"9-15 v: vqhsggmpvmqtbzzlq\r\n" + 
				"12-14 f: ffhfjfffqfxqff\r\n" + 
				"15-16 m: jtnsjwpggbpxlhqmk\r\n" + 
				"2-4 n: xptncjsstcl\r\n" + 
				"5-8 q: dmwklqjqnzb\r\n" + 
				"3-4 c: vcgl\r\n" + 
				"1-6 h: hhhhhh\r\n" + 
				"8-9 x: ckblstcdx\r\n" + 
				"5-7 w: vwphwwmwwwww\r\n" + 
				"2-4 x: kxxxdh\r\n" + 
				"10-11 m: kmmvmmmfmksmj\r\n" + 
				"4-7 v: zvrvvvdvvv\r\n" + 
				"1-8 p: npxbwqpxbjrnrv\r\n" + 
				"5-11 t: jfkwttkstrxlgts\r\n" + 
				"1-2 g: ggggg\r\n" + 
				"5-7 p: tpppppr\r\n" + 
				"15-17 v: vvvvvvvvvvvvvvvvvvvv\r\n" + 
				"17-19 w: dwjwjznczwgfmkmhdtw\r\n" + 
				"10-13 f: fffffbqfffffffffff\r\n" + 
				"4-14 g: ggggggggggggggg\r\n" + 
				"2-3 d: bdkfd\r\n" + 
				"7-8 x: xxxxxxxx\r\n" + 
				"6-9 h: hmshdhvvhkhbhcshs\r\n" + 
				"14-15 g: gggggggggggggghg\r\n" + 
				"2-16 q: qqsxqqqdgqqghqqk\r\n" + 
				"3-17 p: ppbppprppppppppphppp\r\n" + 
				"8-18 v: vczfvqcvvcspndvxwjdv\r\n" + 
				"1-3 d: fdddd\r\n" + 
				"9-11 j: gfjjnjsdnhb\r\n" + 
				"8-10 s: hkhshttssl\r\n" + 
				"5-10 f: ffsffffffqxfff\r\n" + 
				"7-10 w: wwlwwckwwf\r\n" + 
				"4-8 x: blxxmtbgnblfgnfwz\r\n" + 
				"4-5 p: rlpkprppp\r\n" + 
				"13-14 s: ssssssssssssswss\r\n" + 
				"4-8 h: hhhdhmhhhjhlhh\r\n" + 
				"6-7 h: chhhhhfhzqhdhhh\r\n" + 
				"15-17 m: msvrmwzkzvmmgrmmpm\r\n" + 
				"4-6 x: qgtwwxhgsxxmklgmn\r\n" + 
				"4-7 p: rpzkdpp\r\n" + 
				"3-4 v: vvvhvjv\r\n" + 
				"16-18 p: pppppppppppppppppmp\r\n" + 
				"15-17 k: kpkkkkkhqkkkkklktk\r\n" + 
				"5-7 s: ssbxxsk\r\n" + 
				"2-4 l: cwllll\r\n" + 
				"6-9 v: cvvrrkvrvsdvfwcv\r\n" + 
				"1-7 w: qwwwwslwwwwwwwwrww\r\n" + 
				"2-12 c: clcccccccccccccc\r\n" + 
				"5-10 m: ftcmrpmvrzc\r\n" + 
				"7-11 w: wwwwwwwwwwtwwwww\r\n" + 
				"2-3 n: jngdlvgcvtkmn\r\n" + 
				"1-8 v: hvvvvvvvvv\r\n" + 
				"3-17 p: jrpvltxlcqgpfxwsj\r\n" + 
				"1-5 k: kkkkfkk\r\n" + 
				"1-10 c: cccccccccfc\r\n" + 
				"13-19 f: flfffffxfvffffprfmcb\r\n" + 
				"3-6 g: htglsbvrzcghjmd\r\n" + 
				"9-11 h: wrwghhhhnzhxl\r\n" + 
				"5-12 z: zzkzzhnjpmkvzzzw\r\n" + 
				"7-11 w: qrwcwwstwddw\r\n" + 
				"15-19 m: mmmmmmmmmmmmmmmmmmmm\r\n" + 
				"15-16 m: mmmmmmmmmmmmmmhmm\r\n" + 
				"12-16 x: xxxxxcxxxxxlxxxxxxx\r\n" + 
				"5-10 l: qwfqlllgsdjrlspll\r\n" + 
				"3-4 f: hffmfffg\r\n" + 
				"6-7 l: lwlllbllnl\r\n" + 
				"11-20 t: tttkrtlpttwftmwttttt\r\n" + 
				"11-12 d: ddbdddddddpktdd\r\n" + 
				"4-11 w: sxkmkwdwwnlwxmdvfx\r\n" + 
				"4-5 k: kkzkpk\r\n" + 
				"13-20 n: nnnnnntnnnnnbnnnbnnn\r\n" + 
				"5-7 c: ccccwcc\r\n" + 
				"1-6 h: cckkhhdhhwmhhmzchhwx\r\n" + 
				"1-15 b: hbbbbbbbbhbbhbbbbnbb\r\n" + 
				"1-2 w: mwwww\r\n" + 
				"1-2 f: sfzgwtf\r\n" + 
				"3-4 s: sssj\r\n" + 
				"1-3 w: xwww\r\n" + 
				"1-16 p: ppppppppdppppppp\r\n" + 
				"1-6 c: ccxmccccc\r\n" + 
				"4-8 b: rtpbcfbr\r\n" + 
				"9-10 s: sszssstshss\r\n" + 
				"15-16 x: xxxtxxxxxxxmxxxzx\r\n" + 
				"9-15 k: kkkkkkkkkkgrkkkkk\r\n" + 
				"11-13 x: xtxxxxxxxxrxkxx\r\n" + 
				"1-5 f: rffflfffnf\r\n" + 
				"14-16 n: nnxnnnnnnnnnbnzbnnn\r\n" + 
				"3-6 d: ddddddndbdfdhd\r\n" + 
				"14-15 q: sbqqhvqqqvqgxfq\r\n" + 
				"5-6 b: jglbfjb\r\n" + 
				"1-10 l: llllllcllsll\r\n" + 
				"3-5 z: lwzzz\r\n" + 
				"5-12 k: kkkkmkkkkkkkkkkl\r\n" + 
				"8-12 v: vvtsvfvnzvhpm\r\n" + 
				"5-7 l: llllllll\r\n" + 
				"4-7 f: nqfffkbdf\r\n" + 
				"4-8 j: jjjljkhj\r\n" + 
				"9-15 h: vgzpgfhfhmwdhbqc\r\n" + 
				"1-5 p: ptpsjqpnp\r\n" + 
				"5-8 q: qbqqwqnq\r\n" + 
				"5-7 w: wwswwxsb\r\n" + 
				"3-6 h: nnhrnhkmxqkt\r\n" + 
				"1-3 w: jwwww\r\n" + 
				"2-14 x: cxxxxdxxxxxxxbxx\r\n" + 
				"12-14 x: xxxfxxxxqxxrxt\r\n" + 
				"4-9 f: fffkffbsfkxv\r\n" + 
				"12-13 m: mmmmmmmmmmmwm\r\n" + 
				"6-10 p: ppppphpppxppp\r\n" + 
				"9-12 v: vsvvvvkmjvvvn\r\n" + 
				"3-12 r: shngvhbmjrpr\r\n" + 
				"12-13 w: wqwcwxclwwwfw\r\n" + 
				"4-5 r: nnrrdz\r\n" + 
				"4-19 c: vbcpwzvxssccqkqgmxvj\r\n" + 
				"1-6 g: tglxhggng\r\n" + 
				"9-10 z: lvzhvtglzf\r\n" + 
				"10-16 f: gddxfftggfbmxwts\r\n" + 
				"4-12 k: kkkklkkkkkkpkkk\r\n" + 
				"7-11 m: mmmmmmmmmmtm\r\n" + 
				"2-10 z: vkfpjrrvlwlbjwk\r\n" + 
				"3-7 w: dtdzwjqgxdwjhchwwd\r\n" + 
				"13-14 v: vvvvvvvvvvvvvvvv\r\n" + 
				"11-12 c: cjccccqccccc\r\n" + 
				"14-15 h: hzhrhkhfthrhxht\r\n" + 
				"3-5 v: dtwvvvvvcvvvrvsvvv\r\n" + 
				"10-14 q: qhqqkqcqqqqqlfqgsqq\r\n" + 
				"3-14 f: ffvffffffffzffffff\r\n" + 
				"1-12 x: xxtxjxzxxxxxlxxxxxxx\r\n" + 
				"2-4 c: pgpc\r\n" + 
				"1-4 r: fdrr\r\n" + 
				"5-7 r: rrrrrrt\r\n" + 
				"10-11 d: drdddddddmddddpd\r\n" + 
				"2-5 f: gfrlctftzr\r\n" + 
				"10-13 z: nrzjjrzjzzplzmzzbn\r\n" + 
				"8-10 c: cccccccgbc\r\n" + 
				"5-8 g: fgggcndwgggbjnfgb\r\n" + 
				"6-9 d: ddddghdgbddm\r\n" + 
				"3-7 j: ftjjjvjqcp\r\n" + 
				"5-6 s: sqvfstz\r\n" + 
				"5-18 k: kkkwkkkkkkbkkkkkkkbk\r\n" + 
				"3-6 f: djffffkff\r\n" + 
				"4-6 p: pqppppr\r\n" + 
				"5-9 h: hhkhjhmgcqvfhqvhn\r\n" + 
				"8-12 t: tttttttvttttt\r\n" + 
				"14-15 z: pzrzhjqmtbcnzdzr\r\n" + 
				"1-17 s: ssssssssssssswsss\r\n" + 
				"1-4 s: ssqh\r\n" + 
				"1-5 r: rrrrrrr\r\n" + 
				"17-18 h: hhhhhrhcxhhhhhhhhb\r\n" + 
				"7-9 t: dttttjmtv\r\n" + 
				"1-3 c: mcccp\r\n" + 
				"4-5 x: xprbxql\r\n" + 
				"1-5 q: cqqqqqq\r\n" + 
				"3-4 g: ggggw\r\n" + 
				"1-7 f: ffffffnf\r\n" + 
				"7-9 t: ttttttttttt\r\n" + 
				"11-15 m: mmlmfmmmmmmmmmmqm\r\n" + 
				"4-5 n: npnnnn\r\n" + 
				"4-5 b: zvbbvbjhlkf\r\n" + 
				"11-16 c: gnqmcvtzwpcbvncwcc\r\n" + 
				"12-18 q: qbqkwqqvqwqqnljsqpqt\r\n" + 
				"6-10 r: wcrtdrlkgjr\r\n" + 
				"16-17 p: gppppppppwvlgpptp\r\n" + 
				"1-13 g: gqghbwqqzwwdk\r\n" + 
				"1-6 l: rlllll\r\n" + 
				"3-7 j: pdjjtcqwbqtpfkjbwgq\r\n" + 
				"7-17 z: zzhsnjrhrzzfrqszdhdg\r\n" + 
				"6-7 n: xnvnhnrn\r\n" + 
				"6-7 r: rrrrrrzr\r\n" + 
				"2-3 c: ccmcccc\r\n" + 
				"2-3 v: vvdv\r\n" + 
				"3-9 f: mlfffshbfdff\r\n" + 
				"11-13 v: dfvkltvjvvvvx\r\n" + 
				"12-13 c: mqrccccbccbgcccccvc\r\n" + 
				"9-13 w: wwwwwwwwwwwwcwtww\r\n" + 
				"6-8 d: pdvgddtmvwdkvdtzf\r\n" + 
				"1-9 s: hsssssssssdsls\r\n" + 
				"1-5 c: zbsslcd\r\n" + 
				"1-4 p: bpppppppppp\r\n" + 
				"13-16 s: sssxslsscssbqsspcs\r\n" + 
				"1-10 p: pskwpppzpppppks\r\n" + 
				"3-5 c: ccppccmcc\r\n" + 
				"10-11 b: rhbbbbbbbzbb\r\n" + 
				"2-3 d: ndhjhd\r\n" + 
				"3-4 s: sscs\r\n" + 
				"5-6 d: dtwwnt\r\n" + 
				"4-5 d: dddddddd\r\n" + 
				"5-9 z: zztzvzzzz\r\n" + 
				"2-6 v: vpqdll\r\n" + 
				"13-14 d: nxkmbkkpxkcdld\r\n" + 
				"1-3 s: ssss\r\n" + 
				"8-14 z: zzzzzzzzzzzzzbz\r\n" + 
				"16-17 f: fffnffffffftbzffpkf\r\n" + 
				"3-4 m: mtcm\r\n" + 
				"3-4 r: mrdrd\r\n" + 
				"11-13 k: ljkmhdkkkcpjzlmkkzkk\r\n" + 
				"2-3 d: tdqnxpd\r\n" + 
				"3-7 h: mrvdlthxchpvwvssqpk\r\n" + 
				"13-17 j: jjfjjvjjjjjzjsjjksxr\r\n" + 
				"1-4 n: rnnx\r\n" + 
				"7-10 m: mmmmzmxfmm\r\n" + 
				"1-6 r: lrrvrrrrm\r\n" + 
				"4-18 r: rrrdrrrrrrrrrkblrr\r\n" + 
				"6-7 k: kkkkkkl\r\n" + 
				"4-6 v: vmnfvvvvmcmlh\r\n" + 
				"6-9 g: jgcgggkbbmgbs\r\n" + 
				"7-8 t: ttcfwtgjtcttv\r\n" + 
				"3-4 j: tjjj";
	}
		
}