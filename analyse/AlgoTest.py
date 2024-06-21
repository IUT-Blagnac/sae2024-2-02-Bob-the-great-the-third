import unittest
import Efficacite

class AlgoTest(unittest.TestCase):

    def testRLE(self):
        self.assertEqual(Efficacite.RLE(""), "")
        self.assertEqual(Efficacite.RLE("abc"), "1a1b1c")
        self.assertEqual(Efficacite.RLE("abbccc"), "1a2b3c")
        self.assertEqual(Efficacite.RLE("aaabaa"), "3a1b2a")
        self.assertEqual(Efficacite.RLE("aAa"), "1a1A1a")

    def testRLERecursif(self):
        try:
            self.assertEqual(Efficacite.RLEit("", 1), "")
            self.assertEqual(Efficacite.RLEit("", 3), "")
            self.assertEqual(Efficacite.RLEit("abc", 1), "1a1b1c")
            self.assertEqual(Efficacite.RLEit("abbccc", 1), "1a2b3c")
            self.assertEqual(Efficacite.RLEit("aaabaa", 1), "3a1b2a")
            self.assertEqual(Efficacite.RLEit("aAa", 1), "1a1A1a")
            self.assertEqual(Efficacite.RLEit("abc", 2), "111a111b111c")
            self.assertEqual(Efficacite.RLEit("abc", 3), "311a311b311c")

            saeIte20 = "1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211S1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211A1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211E1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211"
            self.assertEqual(Efficacite.RLEit("SAE Algo", 20), saeIte20)
        except Exception as e:
            self.fail(f"Exception inattendue: {e.with_traceback})")


    def testUnRLE(self):
        try:
            self.assertEqual(Efficacite.unRLE(""), "")
            self.assertEqual(Efficacite.unRLE("1a1b1c"), "abc")
            self.assertEqual(Efficacite.unRLE("1a2b3c"), "abbccc")
            self.assertEqual(Efficacite.unRLE("3a1b2a"), "aaabaa")
            self.assertEqual(Efficacite.unRLE("1a1A1a"), "aAa")
        except Exception as e:
            self.fail(f"Exception inattendue: {e}")

    def testUnRLERecursif(self):
        try:
            self.assertEqual(Efficacite.unRLEit("", 1), "")
            self.assertEqual(Efficacite.unRLEit("", 3), "")
            self.assertEqual(Efficacite.unRLEit("1a1b1c", 1), "abc")
            self.assertEqual(Efficacite.unRLEit("1a2b3c", 1), "abbccc")
            self.assertEqual(Efficacite.unRLEit("3a1b2a", 1), "aaabaa")
            self.assertEqual(Efficacite.unRLEit("1a1A1a", 1), "aAa")
            self.assertEqual(Efficacite.unRLEit("111a111b111c", 2), "abc")
            self.assertEqual(Efficacite.unRLEit("311a311b311c", 3), "abc")
        except Exception as e:
            self.fail(f"Exception inattendue: {e}")

    def testBasicScenarios(self):
        # Test empty string
        self.assertEqual(Efficacite.RLE(""), "")

        # Test single character
        self.assertEqual(Efficacite.RLE("a"), "1a")

        # Test string with no repetitions
        self.assertEqual(Efficacite.RLE("abcd"), "1a1b1c1d")

        # Test string with multiple repetitions
        self.assertEqual(Efficacite.RLE("aaaabbbcc"), "4a3b2c")

        # Test string with single and multiple repetitions
        self.assertEqual(Efficacite.RLE("abbbccd"), "1a3b2c1d")

        # Test string with all characters same
        self.assertEqual(Efficacite.RLE("zzzzzzzzzz"), "9z1z")

    def testSpecialCases(self):
        # Test string with numbers
        self.assertEqual(Efficacite.RLE("abccc"), "1a1b3c")

        # Test string with special characters
        self.assertEqual(Efficacite.RLE("!!!@@#"), "3!2@1#")

        # Test string with mixed case characters
        self.assertEqual(Efficacite.RLE("aAbbBB"), "1a1A2b2B")

        longStringInput = "a" * 1000  # Crée une chaîne de 1000 'a'
        expectedOutput = "9a" * 111 + "1a"  # Attendu: "9a" * 111 + "1a"

        self.assertEqual(Efficacite.RLE(longStringInput), expectedOutput)

    def testRLE(self):
        self.assertEqual(Efficacite.RLE("aaaabbbcc"), "4a3b2c")
        self.assertEqual(Efficacite.RLE("abcde"), "1a1b1c1d1e")
        self.assertEqual(Efficacite.RLE("a"), "1a")
        self.assertEqual(Efficacite.RLE(""), "")
        self.assertEqual(Efficacite.RLE("aaaaaaaaaa"), "9a1a")  # Test with a run length > 9

    def testUnRLE(self):
        try:
            self.assertEqual(Efficacite.unRLE("4a3b2c"), "aaaabbbcc")
            self.assertEqual(Efficacite.unRLE("1a1b1c1d1e"), "abcde")
            self.assertEqual(Efficacite.unRLE("1a"), "a")
            self.assertEqual(Efficacite.unRLE(""), "")
            self.assertEqual(Efficacite.unRLE("9a1a"), "aaaaaaaaaa")  # Test with a run length > 9
        except Exception as e:
            self.fail(f"Exception inattendue: {e}")

    def testRLEWithIteration(self):
        try:
            self.assertEqual(Efficacite.RLEit("aaaabbbcc", 1), "4a3b2c")
            self.assertEqual(Efficacite.RLEit("aaaabbbcc", 2), "141a131b121c")  # Second iteration of RLE
            self.assertEqual(Efficacite.RLEit("aaaabbbcc", 3), "1114111a1113111b1112111c")  # Third iteration of RLE
            self.assertEqual(Efficacite.RLEit("", 3), "")
        except Exception as e:
            self.fail(f"Exception inattendue: {e}")

if __name__ == '__main__':
    unittest.main()
