package com.chunyue.utilLang;

public class PackageClassDemoMain {
    public static void main(String[] args) {
        // get all the packages available
        Package[] packages = Package.getPackages();
        for (Package p: packages){
            System.out.println(p.getName() + " " +
                    p.getImplementationTitle() + " " +
                    p.getImplementationVendor() + " " +
                    p.getImplementationVersion());
        }
    }
}
