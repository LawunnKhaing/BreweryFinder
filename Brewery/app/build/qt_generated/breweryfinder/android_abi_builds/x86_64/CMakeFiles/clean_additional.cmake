# Additional clean files
cmake_minimum_required(VERSION 3.16)

if("${CONFIG}" STREQUAL "" OR "${CONFIG}" STREQUAL "")
  file(REMOVE_RECURSE
  "CMakeFiles/breweryfinderApp_autogen.dir/AutogenUsed.txt"
  "CMakeFiles/breweryfinderApp_autogen.dir/ParseCache.txt"
  "breweryfinderApp_autogen"
  )
endif()
