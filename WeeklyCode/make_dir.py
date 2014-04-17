import os

if __name__ == '__main__':
	base_dir=input("base dir: ")
	os.mkdir(base_dir)

	while True:
		sub_dir=input("problem dir: ")
		sub_dir=sub_dir.strip(' -')
		if len(sub_dir)==0:
			break
		os.mkdir(base_dir+"/"+sub_dir)
