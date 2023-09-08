
Pod::Spec.new do |s|
  s.name         = "rn-auryc-sdk"
  s.version      = "2.2.9"
  s.summary      = "RNAuryc"
  s.description  = <<-DESC
                  RNAuryc
                   DESC
  s.homepage     = "www.auryc.com"
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "author@domain.cn" }
  s.platform     = :ios, "9.0"
  s.source       = { :git => "https://github.com/auryc-inc/react-native-auryc.git", :branch => "master" }
  # s.source       = { :path => '.' }
  s.source_files  = "ios/**.{h,m}"
  s.requires_arc = true


  s.dependency "React"
  s.dependency "AurycSDK", ">= 2.1.1"

end
