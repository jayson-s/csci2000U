from autotest import *

T = Test("Test 1")
T.add(10, "Test cases", NB('worksheet.ipynb', 'tests/tests.ipynb'))
T.report()
