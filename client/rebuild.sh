for i in "$(npm prefix -g)/lib/node_modules/"*; do
	  sudo npm build -g "$i"
  done
