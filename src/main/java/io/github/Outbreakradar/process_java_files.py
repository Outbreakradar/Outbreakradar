import os

# Get the current directory
current_directory = os.path.dirname(os.path.abspath(__file__))

# List all files in the current directory
all_files = os.listdir(current_directory)

# Filter for .java files
java_files = [f for f in all_files if f.endswith('.java')]

# Open the output file in append mode
with open('java_files_content.txt', 'a') as output_file:
    # Iterate over the java files
    for java_file in java_files:
        # Write the filename
        output_file.write(f'--- {java_file} ---\n\n')
        # Open and read the java file
        with open(os.path.join(current_directory, java_file), 'r') as input_file:
            # Write the content of the java file to the output file
            output_file.write(input_file.read())
            output_file.write('\n\n')

print("Java files have been processed and appended to java_files_content.txt")
