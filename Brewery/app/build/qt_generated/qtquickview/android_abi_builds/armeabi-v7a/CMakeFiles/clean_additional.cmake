# Additional clean files
cmake_minimum_required(VERSION 3.16)

if("${CONFIG}" STREQUAL "" OR "${CONFIG}" STREQUAL "")
  file(REMOVE_RECURSE
  "CMakeFiles/qtquickview_autogen.dir/AutogenUsed.txt"
  "CMakeFiles/qtquickview_autogen.dir/ParseCache.txt"
  "qtquickview_autogen"
  )
endif()
