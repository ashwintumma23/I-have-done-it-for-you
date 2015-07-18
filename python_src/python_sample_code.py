#####################################################################
# Sample Python code for testing the tool for validating the tests
# logging an issue on Github
#
# Inputs: InputFile.txt - File containing the numberic input values
# Outputs: >  python_output.output  - Standard Output
#          2> python_program_log.log - Standard Error
# Usage: python python_sample_code.py > python_output.output 2> python_program_log.log
#####################################################################

# Create sample files, write sample data to them, and perform 
# mathematical calculations on them
def create_files_calculation():
	values_sum = 0
	index = 0
	fp = open("InputFile.txt","r")
	for line in fp:
		values_sum += int(line.strip())
		index +=1
	fp.close()
	
	# Performing a deliberate computational err here
	# This should result in a division by Zero error
	index = 0
	print "Values Average = ", str(values_sum/index)
 

# Main function for calling other sub-routines
def main():
	create_files_calculation()

main()
