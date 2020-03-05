from autotest import *
import os

T = Test("Test 1")

# See https://docs.python.org/3.6/library/unittest.html
# for all list of helper functions in the form
# of assertXXX(...)

import math

#
# More testcase
#

# BASH(command, output, expect_file, expect_returncode, ignore_ws, ignore_case)
# NB(source_nb, test_nb, [output_nb])

T.add(10, "Basic notebook tests",
        NB('worksheet.ipynb', 'test.ipynb'))

if os.path.exists("tests/test2.ipynb"):
    T.add(90, "Basic notebook tests",
            NB('worksheet.ipynb', 'tests/test2.ipynb'))

T.report()
