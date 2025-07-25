//
//  AUIAICallAgentConfig.swift
//  AUIAICall
//
//  Created by Bingo on 2024/12/23.
//


import UIKit
import AUIFoundation
import ARTCAICallKit

let VoiceAgentId = "f05abdde9e5648efb966c3cb46361c5a"
let AvatarAgentId = ""
let VisionAgentId = "47b870aa48cc49d1b43485042c6ddcf5"
let VideoAgentId = ""
let ChatAgentId = ""

let VoiceAgentEmotionalId = ""
let AvatarAgentEmotionalId = ""
let VisionAgentEmotionalId = ""
let VideoAgentEmotionalId = ""

let Region = "cn-hangzhou"

@objcMembers open class AUIAICallAgentConfig: NSObject {
    
    public static let shared: AUIAICallAgentConfig = AUIAICallAgentConfig()
    
    override init() {
        
        let emotional = UserDefaults.standard.object(forKey: "agent_config_emotional") as? Bool
        self.emotional = emotional ?? false
    }
    
    var emotional: Bool = false {
        didSet {
            UserDefaults.standard.set(self.emotional, forKey: "agent_config_emotional")
        }
    }
    
    let enableOutboundCall = false

    public func getAgentID(agentType: ARTCAICallAgentType, emotional: Bool = true) -> String? {
        var ret: String? = nil
        switch agentType {
        case .VoiceAgent:
            ret = emotional && self.emotional ? VoiceAgentEmotionalId : VoiceAgentId
        case .AvatarAgent:
            ret = emotional && self.emotional ? AvatarAgentEmotionalId : AvatarAgentId
        case .VisionAgent:
            ret = emotional && self.emotional ? VisionAgentEmotionalId : VisionAgentId
        case .VideoAgent:
            ret = emotional && self.emotional ? VideoAgentEmotionalId : VideoAgentId
        }
        
        // 为空值的情况下，使用在AppServer上配置的智能体Id
        if ret != nil && ret!.isEmpty == true {
            return nil
        }
        return ret
    }
    
    public func getChatAgentId() -> String {
        return ChatAgentId
    }
    
    public func getRegion() -> String {
        return Region
    }
}


@objcMembers open class AUIAICallAgentConfigPanel: AVBaseControllPanel {

    public override init(frame: CGRect) {
        super.init(frame: frame)
        
        self.titleView.text = AUIAICallBundle.getString("Options")
        self.contentView.addSubview(self.emotionLabel)
        self.contentView.addSubview(self.emotionInfoLabel)
        self.contentView.addSubview(self.unemotionalBtn)
        self.contentView.addSubview(self.emotionalBtn)
        
        self.emotionalBtn.isSelected = AUIAICallAgentConfig.shared.emotional
        self.unemotionalBtn.isSelected = !self.emotionalBtn.isSelected
    }
    
    open override func layoutSubviews() {
        super.layoutSubviews()
        
        self.updateLayout()
    }

    public required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    open override class func panelHeight() -> CGFloat {
        return 156 + 46
    }
    
    private func updateLayout() {
        
        var top: CGFloat = 16
        self.emotionLabel.frame = CGRect(x: 20, y: top, width: self.contentView.av_width - 40, height: 22)
        
        top = self.emotionLabel.av_bottom + 4
        self.emotionInfoLabel.frame = CGRect(x: self.emotionLabel.av_left, y: top, width: self.emotionLabel.av_width, height: 16)
        
        top = self.emotionInfoLabel.av_bottom + 12
        self.unemotionalBtn.sizeToFit()
        self.unemotionalBtn.frame = CGRect(x: 20, y: top, width: self.unemotionalBtn.av_width, height: 32)
        self.emotionalBtn.sizeToFit()
        self.emotionalBtn.frame = CGRect(x: self.unemotionalBtn.av_right + 16, y: top, width: self.emotionalBtn.av_width, height: 32)
    }
    
    lazy var emotionLabel: UILabel = {
        let label = UILabel()
        label.font = AVTheme.regularFont(14)
        label.textColor = AVTheme.text_strong
        label.text = AUIAICallBundle.getString("Emotion Support")
        return label
    }()
    
    lazy var emotionInfoLabel: UILabel = {
        let label = UILabel()
        label.font = AVTheme.regularFont(10)
        label.textColor = AVTheme.text_weak
        label.text = AUIAICallBundle.getString("Does agent support emotional label output?")
        return label
    }()
    
    lazy var unemotionalBtn: AVBlockButton = {
        let btn = AVBlockButton()
        btn.titleLabel?.font = AVTheme.regularFont(12)
        btn.setTitle(AUIAICallBundle.getString("Unemotional"), for: .normal)
        btn.setTitleColor(AVTheme.text_weak, for: .normal)
        btn.setTitleColor(AVTheme.text_strong, for: .selected)
        btn.layer.cornerRadius = 16
        btn.layer.borderWidth = 1
        btn.setBorderColor(AVTheme.border_weak, for: .normal)
        btn.setBorderColor(AVTheme.colourful_border_weak, for: .selected)
        btn.contentEdgeInsets = UIEdgeInsets(top: 0, left: 16, bottom: 0, right: 16)
        btn.clickBlock = { [weak self] btn in
            guard let self = self else { return }
            self.unemotionalBtn.isSelected = !self.unemotionalBtn.isSelected
            self.emotionalBtn.isSelected = !self.unemotionalBtn.isSelected
            AUIAICallAgentConfig.shared.emotional = self.emotionalBtn.isSelected
        }
        return btn
    }()
    
    lazy var emotionalBtn: AVBlockButton = {
        let btn = AVBlockButton()
        btn.titleLabel?.font = AVTheme.regularFont(12)
        btn.setTitle(AUIAICallBundle.getString("Emotional"), for: .normal)
        btn.setTitleColor(AVTheme.text_weak, for: .normal)
        btn.setTitleColor(AVTheme.text_strong, for: .selected)
        btn.layer.cornerRadius = 16
        btn.layer.borderWidth = 1
        btn.setBorderColor(AVTheme.border_weak, for: .normal)
        btn.setBorderColor(AVTheme.colourful_border_weak, for: .selected)
        btn.contentEdgeInsets = UIEdgeInsets(top: 0, left: 16, bottom: 0, right: 16)
        btn.clickBlock = { [weak self] btn in
            guard let self = self else { return }
            self.emotionalBtn.isSelected = !self.emotionalBtn.isSelected
            self.unemotionalBtn.isSelected = !self.emotionalBtn.isSelected
            AUIAICallAgentConfig.shared.emotional = self.emotionalBtn.isSelected
        }
        return btn
    }()
}
