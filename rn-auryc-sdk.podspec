
Pod::Spec.new do |s|
  s.name         = "rn-auryc-sdk"
  s.version      = "1.0.0"
  s.summary      = "RNAuryc"
  s.description  = <<-DESC
                  RNAuryc
                   DESC
  s.homepage     = "www.auryc.com"
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "author@domain.cn" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/author/RNAuryc.git", :branch => "master" }
  # s.source       = { :path => '.' }
  s.source_files  = "ios/**.{h,m}"
  s.requires_arc = true


  s.dependency "React", '~> 0.57.4'
  s.dependency "AurycSDK"

end
